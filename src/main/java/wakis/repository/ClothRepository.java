package wakis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wakis.entity.Cloth;
@Repository
public interface ClothRepository extends JpaRepository<Cloth, Long> {
}
