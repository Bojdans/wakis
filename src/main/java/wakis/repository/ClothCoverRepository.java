package wakis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wakis.entity.covers.ClothCover;
@Repository
public interface ClothCoverRepository  extends JpaRepository<ClothCover, Long> {
}
