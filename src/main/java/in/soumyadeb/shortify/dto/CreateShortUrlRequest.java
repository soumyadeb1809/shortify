package in.soumyadeb.shortify.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateShortUrlRequest {
    private String title;
    private String shortName;
    private String longUrl;
}
