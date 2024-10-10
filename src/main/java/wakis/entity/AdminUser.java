package wakis.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakis.enums.Permissions;

@Data
@NoArgsConstructor
@Entity
@Table(name = "admin_user")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_user_id",columnDefinition = "bigserial")
    private Long adminUserId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "description")
    private String description;
    @Column(name = "permissions")
    @Enumerated(EnumType.STRING)
    private Permissions permissions;
    public AdminUser(String login, String password, String description, Permissions permissions) {
        this.login = login;
        this.password = password;
        this.description = description;
        this.permissions = permissions;
    }
}