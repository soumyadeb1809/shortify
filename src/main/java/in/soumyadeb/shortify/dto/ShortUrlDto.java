package in.soumyadeb.shortify.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ShortUrlDto {
    private Integer id;
    private String title;
    private String shortName;
    private String longUrl;
    private Integer userId;
}
