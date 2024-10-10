package wakis.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "promocode")
public class Promocode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promocode_id", columnDefinition = "bigserial")
    private Long promocodeId;
    @Column(name = "promocode")
    private String promocodeName;
    @Column(name = "discount")
    private Long discount;
    @Column(name = "description")
    private String description;

    public Promocode(String promocodeName, Long discount, String description) {
        this.promocodeName = promocodeName;
        this.discount = discount;
        this.description = description;
    }
}