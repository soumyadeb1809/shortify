package in.soumyadeb.shortify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

    @GetMapping("/{subUrl}")
    public RedirectView redirect(
            @PathVariable("subUrl") String subUrl
    ) {

        return new RedirectView("https://youtube.com");
    }

}
