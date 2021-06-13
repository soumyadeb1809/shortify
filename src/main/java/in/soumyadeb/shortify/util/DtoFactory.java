package in.soumyadeb.shortify.util;

import in.soumyadeb.shortify.dto.ShortUrlDto;
import in.soumyadeb.shortify.dto.UserDto;
import in.soumyadeb.shortify.entity.ShortUrl;
import in.soumyadeb.shortify.entity.User;

public class DtoFactory {

    /**
     * Factory method to create UserDto.
     *
     * @param user entity
     * @return instance of UserDto
     */
    public static UserDto createUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    /**
     * Factory method to create ShortUrlDto.
     *
     * @param shortUrl entity
     * @param userId user Id
     * @return instance of UserDto
     */
    public static ShortUrlDto createShortUrlDto(ShortUrl shortUrl, Integer userId) {
        ShortUrlDto shortUrlDto = new ShortUrlDto();
        shortUrlDto.setId(shortUrl.getId());
        shortUrlDto.setTitle(shortUrl.getTitle());
        shortUrlDto.setShortName(shortUrl.getShortName());
        shortUrlDto.setLongUrl(shortUrl.getLongUrl());
        shortUrlDto.setUserId(userId);

        return shortUrlDto;
    }
}
