package in.soumyadeb.shortify.util;

import in.soumyadeb.shortify.dto.CreateShortUrlRequest;
import in.soumyadeb.shortify.dto.CreateUserRequest;
import in.soumyadeb.shortify.entity.MapUserShortUrl;
import in.soumyadeb.shortify.entity.ShortUrl;
import in.soumyadeb.shortify.entity.User;

public class EntityBuilder {

    /**
     * Builder method to build User entity.
     *
     * @param user entity to build
     * @param request dto
     */
    public static void build(User user, CreateUserRequest request) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }

    /**
     * Builder method to build ShortUrl entity.
     *
     * @param shortUrl entity to build
     * @param request dto
     */
    public static void build(ShortUrl shortUrl, CreateShortUrlRequest request) {
        shortUrl.setShortName(request.getShortName());
        shortUrl.setLongUrl(request.getLongUrl());
        shortUrl.setTitle(request.getTitle());
    }

    /**
     * Builder method to build MapUserShortUrl entity.
     *
     * @param mapUserShortUrl entity to build
     * @param userId User Id
     * @param shortUrlId ShortUrl Id
     */
    public static void build(MapUserShortUrl mapUserShortUrl, Integer userId, Integer shortUrlId) {
        User user = new User(userId);
        ShortUrl shortUrl = new ShortUrl(shortUrlId);

        mapUserShortUrl.setShortUrl(shortUrl);
        mapUserShortUrl.setUser(user);
    }
}
