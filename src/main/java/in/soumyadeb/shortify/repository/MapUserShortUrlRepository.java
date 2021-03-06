package in.soumyadeb.shortify.repository;

import in.soumyadeb.shortify.entity.MapUserShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapUserShortUrlRepository extends JpaRepository<MapUserShortUrl, Integer> {

    @Query("FROM MapUserShortUrl WHERE user.id = :userId")
    List<MapUserShortUrl> findByUser(
            @Param("userId") Integer userId
    );

    @Query("FROM MapUserShortUrl WHERE shortUrl.id = :shortUrlId")
    List<MapUserShortUrl> findByShortUrlId(
            @Param("shortUrlId") Integer shortUrlId
    );
}
