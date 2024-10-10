package wakis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wakis.entity.covers.ClothSize;
@Repository
public interface ClothSizeRepository extends JpaRepository<ClothSize, Long> {

}
