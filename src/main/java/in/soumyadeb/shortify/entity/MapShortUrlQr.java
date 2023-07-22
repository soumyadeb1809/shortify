package in.soumyadeb.shortify.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "map_short_url_qr")
public class MapShortUrlQr {

    @Id
    @Column(name = "short_url_id", nullable = false)
    private Integer shortUrlId;

    @Column(name = "qr_id")
    private Integer qrId;
}
