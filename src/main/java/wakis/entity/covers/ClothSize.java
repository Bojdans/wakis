package wakis.entity.covers;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cloth_size")
public class ClothSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_size_id",columnDefinition = "bigserial")
    private Long clothSizeId;
    @Column(name = "cloth_size")
    private String clothSize;
    @Column(name = "quantity")
    private Long quantity;

    public ClothSize(String clothSize, Long quantity) {
        this.clothSize = clothSize;
        this.quantity = quantity;
    }
}