package in.soumyadeb.shortify.controller;

import in.soumyadeb.shortify.dto.*;
import in.soumyadeb.shortify.constants.ResponseMessage;
import in.soumyadeb.shortify.service.QrCodeService;
import in.soumyadeb.shortify.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urls")
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping
    public CreateResourceResponse createShortUrl(
            @RequestParam("userId") Integer userId,
            @RequestBody CreateShortUrlRequest request
    ) {
        CreateResourceResponse response = new CreateResourceResponse();

        Integer id = shortUrlService.createShortUrl(request, userId);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return response;
    }

    @GetMapping
    public ResourceListResponse<ShortUrlDto> getShortUrls(
            @RequestParam("userId") Integer userId
    ) {
        ResourceListResponse<ShortUrlDto> response = new ResourceListResponse<>();

        List<ShortUrlDto> shortUrls = shortUrlService.getShortUrls(userId);
        response.setData(shortUrls);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @DeleteMapping("/{id}")
    public DeleteResourceResponse deleteShortUrl(
            @PathVariable("id") Integer id
    ) {
        DeleteResourceResponse response = new DeleteResourceResponse();

        id = shortUrlService.deleteShortUrl(id);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.NOT_FOUND);
        }

        return response;
    }

    @PostMapping("/qr")
    public ResourceResponse<QrCodeDto> createQrCode(CreateShortUrlQrRequest request) {
        ResourceResponse<QrCodeDto> response = new ResourceResponse<>();

        QrCodeDto qrCodeDto = qrCodeService.generateQrCode(request.getShortUrlId());
        response.setData(qrCodeDto);

        if(qrCodeDto != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.NOT_FOUND);
        }
        return response;
    }

    @GetMapping("/qr/{shortUrlId}")
    public ResourceResponse<QrCodeDto> getQrCode(@PathVariable("shortUrlId") Integer shortUrlId) {
        ResourceResponse<QrCodeDto> response = new ResourceResponse<>();

        QrCodeDto qrCodeDto = qrCodeService.getQrCode(shortUrlId);
        response.setData(qrCodeDto);

        if(qrCodeDto != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }
        return response;
    }

}
