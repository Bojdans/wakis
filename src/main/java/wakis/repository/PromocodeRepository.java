package wakis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wakis.entity.Promocode;
@Repository
public interface PromocodeRepository extends JpaRepository<Promocode,Long> {
    Promocode findByPromocodeName(String promocodeName);
}
