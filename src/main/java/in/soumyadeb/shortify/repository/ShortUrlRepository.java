package in.soumyadeb.shortify.repository;

import in.soumyadeb.shortify.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends JpaRepository<Integer, ShortUrl> {
}
