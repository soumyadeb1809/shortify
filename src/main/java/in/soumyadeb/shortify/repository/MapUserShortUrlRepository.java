package in.soumyadeb.shortify.repository;

import in.soumyadeb.shortify.entity.MapUserShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapUserShortUrlRepository extends JpaRepository<Integer, MapUserShortUrl> {
}
