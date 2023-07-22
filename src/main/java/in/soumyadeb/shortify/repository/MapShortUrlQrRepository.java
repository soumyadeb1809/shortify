package in.soumyadeb.shortify.repository;

import in.soumyadeb.shortify.entity.MapShortUrlQr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MapShortUrlQrRepository {

    @Query("FROM MapShortUrlQr WHERE shortUrlId = :shortUrlId")
    MapShortUrlQr findByShortUrlId(
            @Param("shortUrlId") Integer shortUrlId
    );
}
