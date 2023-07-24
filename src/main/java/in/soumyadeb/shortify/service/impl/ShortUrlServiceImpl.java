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

    private final ShortUrlRepository shortUrlRepo;

    private final MapUserShortUrlRepository mapUserShortUrlRepo;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlRepository shortUrlRepo, MapUserShortUrlRepository mapUserShortUrlRepo) {
        this.shortUrlRepo = shortUrlRepo;
        this.mapUserShortUrlRepo = mapUserShortUrlRepo;
    }

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

    @Transactional(readOnly = true)
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

    @Transactional
    @Override
    public Integer deleteShortUrl(Integer id) {
        try {
            Optional<ShortUrl> shortUrlOp = shortUrlRepo.findById(id);

            if(!shortUrlOp.isPresent()) {
                System.out.println("Not found ShortUrl Id: " + id);
                return null;
            }

            ShortUrl shortUrl = shortUrlOp.get();
            shortUrl.setDeleted(true);
            shortUrlRepo.save(shortUrl);
            System.out.println("Deleted ShortUrl Id: " + id);

            List<MapUserShortUrl> mappedShortUrls = mapUserShortUrlRepo.findByShortUrlId(id);
            mappedShortUrls.forEach(mapUserShortUrl -> mapUserShortUrl.setDeleted(true));
            mapUserShortUrlRepo.saveAll(mappedShortUrls);
            System.out.println("Deleted MapUserShortUrl count: " + mappedShortUrls.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    @Transactional(readOnly = true)
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
