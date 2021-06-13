package in.soumyadeb.shortify.repository;

import in.soumyadeb.shortify.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer> {

    @Query("FROM ShortUrl WHERE shortName = :shortName")
    Optional<ShortUrl> findByShortName(
            @Param("shortName") String shortName
    );
}
