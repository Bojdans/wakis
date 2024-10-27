package wakis.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakis.entity.covers.ClothCover;
import wakis.enums.OrderStatus;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "order_cloth")
public class OrderCloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_cloth_id",columnDefinition = "bigserial")
    private Long orderClothId;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "telegram_username")
    private String telegramUsername;
    @Column(name = "city")
    private String city;
    @Column(name = "order_cloth_pickup_point")
    private String orderClothPickupPoint;
    @Column(name = "total_cost")
    private Long totalCost;
    @OneToOne
    @JoinColumn(name = "promocode_id",referencedColumnName = "promocode_id",columnDefinition = "bigint")
    private Promocode promocode;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cloth_cover_order_cloth",
            joinColumns = @JoinColumn(name = "order_cloth_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_cover_id")
    )
    private List<ClothCover> clothCovers;
    public OrderCloth(String email, String phoneNumber, String telegramUsername, String city, String orderClothPickupPoint, Promocode promocode, OrderStatus orderStatus, List<ClothCover> clothCovers) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.telegramUsername = telegramUsername;
        this.city = city;
        this.orderClothPickupPoint = orderClothPickupPoint;
        this.promocode = promocode;
        this.orderStatus = orderStatus;
        this.clothCovers = clothCovers;
    }
    public OrderCloth(String email, String phoneNumber, String telegramUsername, String city, String orderClothPickupPoint, OrderStatus orderStatus, List<ClothCover> clothCovers) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.telegramUsername = telegramUsername;
        this.city = city;
        this.orderClothPickupPoint = orderClothPickupPoint;
        this.orderStatus = orderStatus;
        this.clothCovers = clothCovers;
    }
}
