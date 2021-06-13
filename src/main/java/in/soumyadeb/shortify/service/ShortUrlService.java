package in.soumyadeb.shortify.service;

import in.soumyadeb.shortify.dto.CreateShortUrlRequest;
import in.soumyadeb.shortify.dto.ShortUrlDto;

import java.util.List;

public interface ShortUrlService {

    /**
     * Service to create a new ShortUrl.
     *
     * @param request dto
     * @param userId user Id
     * @return Id of the created ShortUrl
     */
    Integer createShortUrl(CreateShortUrlRequest request, Integer userId);

    /**
     * Service to get all short urls for a user.
     *
     * @param userId user Id
     * @return list of ShortUrlDto
     */
    List<ShortUrlDto> getShortUrls(Integer userId);

    /**
     * Service to delete an existing ShortUrl and its mappings.
     *
     * @param id ShortUrlId
     * @return id of the deleted ShortUrl, null if id is not found
     */
    Integer deleteShortUrl(Integer id);

    /**
     * Service to get a long url by its shortName.
     *
     * @param shortName shortName of the ShortUrl
     * @return String containing longUrl if found, else null
     */
    String getLongUrl(String shortName);
}
