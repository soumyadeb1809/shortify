package in.soumyadeb.shortify.service.impl;

import in.soumyadeb.shortify.dto.CreateShortUrlRequest;
import in.soumyadeb.shortify.dto.ShortUrlDto;
import in.soumyadeb.shortify.entity.MapUserShortUrl;
import in.soumyadeb.shortify.entity.ShortUrl;
import in.soumyadeb.shortify.repository.MapUserShortUrlRepository;
import in.soumyadeb.shortify.repository.ShortUrlRepository;
import in.soumyadeb.shortify.service.ShortUrlService;
import in.soumyadeb.shortify.util.DtoFactory;
import in.soumyadeb.shortify.util.EntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    @Autowired
    private ShortUrlRepository shortUrlRepo;

    @Autowired
    private MapUserShortUrlRepository mapUserShortUrlRepo;

    @Transactional
    @Override
    public Integer createShortUrl(CreateShortUrlRequest request, Integer userId) {
        ShortUrl shortUrl = new ShortUrl();

        try {
            EntityBuilder.build(shortUrl, request);
            shortUrlRepo.save(shortUrl);
            Integer shortUrlId = shortUrl.getId();
            System.out.println("Created ShortUrl Id: " + shortUrlId);

            MapUserShortUrl mapUserShortUrl = new MapUserShortUrl();
            EntityBuilder.build(mapUserShortUrl, userId, shortUrlId);
            mapUserShortUrlRepo.save(mapUserShortUrl);
            System.out.println("Mapped ShortUrl Id: " + shortUrlId + " with User Id: " + userId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return shortUrl.getId();
    }

    @Override
    public List<ShortUrlDto> getShortUrls(Integer userId) {
        List<ShortUrlDto> shortUrlDtoList = new ArrayList<>();

        try {
            List<MapUserShortUrl> mappedShortUrls = mapUserShortUrlRepo.findByUser(userId);
            mappedShortUrls.forEach(mappedShortUrl ->
                    shortUrlDtoList.add(DtoFactory.createShortUrlDto(mappedShortUrl.getShortUrl(), userId))
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return shortUrlDtoList;
    }

    @Override
    public String getLongUrl(String shortName) {
        String longUrl = null;

        try {
            Optional<ShortUrl> shortUrlOp = shortUrlRepo.findByShortName(shortName);

            if(!shortUrlOp.isPresent()) {
                System.out.println("Short name not found: " + shortName);
                return null;
            }

            longUrl = shortUrlOp.get().getLongUrl();
            System.out.println("Short name: " + shortName + ", resolved Long Url: " + longUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return longUrl;
    }
}
