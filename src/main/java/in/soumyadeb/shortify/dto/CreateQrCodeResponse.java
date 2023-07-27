package in.soumyadeb.shortify.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateQrCodeResponse extends BaseResponse {
    private Integer id;
    private QrCodeDto data;
}
