package in.soumyadeb.shortify.repository;

import in.soumyadeb.shortify.entity.MapShortUrlQr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MapShortUrlQrRepository extends JpaRepository<MapShortUrlQr, Integer> {

    @Query("FROM MapShortUrlQr WHERE shortUrlId = :shortUrlId")
    MapShortUrlQr findByShortUrlId(
            @Param("shortUrlId") Integer shortUrlId
    );
}
