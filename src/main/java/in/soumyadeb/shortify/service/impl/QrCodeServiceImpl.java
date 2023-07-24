package in.soumyadeb.shortify.service.impl;

import in.soumyadeb.shortify.dto.*;
import in.soumyadeb.shortify.entity.MapShortUrlQr;
import in.soumyadeb.shortify.entity.ShortUrl;
import in.soumyadeb.shortify.repository.MapShortUrlQrRepository;
import in.soumyadeb.shortify.repository.ShortUrlRepository;
import in.soumyadeb.shortify.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class QrCodeServiceImpl implements QrCodeService {

    @Value("${qrcode.service.host}")
    private String host;

    @Value("${qrcode.service.api.endpoint}")
    private String endPoint;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MapShortUrlQrRepository mapShortUrlQrRepo;

    @Autowired
    private ShortUrlRepository shortUrlRepository;


    @Override
    public QrCodeDto generateQrCode(Integer shortUrlId) {
        Optional<ShortUrl> shortUrlOp = shortUrlRepository.findById(shortUrlId);
        return shortUrlOp.map(shortUrl -> createQrCode(shortUrl.getShortName()).getData()).orElse(null);
    }

    @Override
    public QrCodeDto getQrCode(Integer shortUrlId) {
        MapShortUrlQr mapShortUrlQr = mapShortUrlQrRepo.findByShortUrlId(shortUrlId);
        if(mapShortUrlQr == null) {
            return null;
        }
        return getQrCode(mapShortUrlQr.getQrId());
    }

    private CreateQrCodeResponse createQrCode(String shortUrl) {
        CreateQrCodeRequest request = new CreateQrCodeRequest();
        request.setMetadata(shortUrl);
        HttpEntity<CreateQrCodeRequest> entity = new HttpEntity<>(request);
        return restTemplate.postForObject(getQrCodeServiceUrl(), entity, CreateQrCodeResponse.class);
    }

    private GetQrCodeResponse getQrCode(String qrCodeId) {
        return restTemplate.getForObject(
                getQrCodeServiceUrl() + "/" + qrCodeId, GetQrCodeResponse.class
        );
    }

    private String getQrCodeServiceUrl() {
        return host + endPoint;
    }
}
