package in.soumyadeb.shortify.controller;

import in.soumyadeb.shortify.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

    @Autowired
    private ShortUrlService shortUrlService;

    @GetMapping("/{shortName}")
    public RedirectView redirect(
            @PathVariable("shortName") String shortName
    ) {
        String redirectUrl = "/404";

        String longUrl = shortUrlService.getLongUrl(shortName);

        if(longUrl != null && !longUrl.isEmpty()) {
            redirectUrl = longUrl;
        }

        return new RedirectView(redirectUrl);
    }

    @GetMapping("/404")
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<>("<h1>404: Not Found</h1>", HttpStatus.NOT_FOUND);
    }

}
