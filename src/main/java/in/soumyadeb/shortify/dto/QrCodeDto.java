package in.soumyadeb.shortify.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QrCodeDto {
    private Integer id;
    private String imageUrl;
}
