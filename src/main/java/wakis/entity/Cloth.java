package wakis.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakis.entity.covers.ClothSize;
import wakis.enums.ClothType;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cloth")
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_id",columnDefinition = "bigserial")
    private Long clothId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ClothType type;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cloth_cloth_size",
            joinColumns = @JoinColumn(name = "cloth_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_size_id")
    )
    private List<ClothSize> clothSizes;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images;
    @Column(name = "cost")
    private Long cost;
    @Column(name = "fake_cost")
    private Long fakeCost;

    public Cloth(String name, String description, List<ClothSize> clothSizes, ClothType type, List<String> images, Long cost, Long fakeCost) {
        this.name = name;
        this.description = description;
        this.clothSizes = clothSizes;
        this.type = type;
        this.images = images;
        this.cost = cost;
        this.fakeCost = fakeCost;
    }

}
