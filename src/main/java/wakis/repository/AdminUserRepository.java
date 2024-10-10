package wakis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wakis.entity.AdminUser;
@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

}
