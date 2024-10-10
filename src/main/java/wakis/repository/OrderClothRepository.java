package wakis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wakis.entity.OrderCloth;

@Repository
public interface OrderClothRepository extends JpaRepository<OrderCloth, Long> {
}
