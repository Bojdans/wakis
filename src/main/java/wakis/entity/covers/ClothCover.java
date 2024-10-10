package wakis.entity.covers;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakis.entity.Cloth;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cloth_cover")
public class ClothCover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_cover_id",columnDefinition = "bigserial")
    private Long clothCoverId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cloth_id",referencedColumnName = "cloth_id",columnDefinition = "bigint")
    private Cloth cloth;
    @Column(name = "size")
    private String size;
    @Column(name = "quantity")
    private Long quantity;

    public ClothCover(Cloth cloth, String size, Long quantity) {
        this.cloth = cloth;
        this.size = size;
        this.quantity = quantity;
    }
}