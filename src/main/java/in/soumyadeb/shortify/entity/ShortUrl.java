package in.soumyadeb.shortify.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "short_url")
@Where(clause = "deleted = false")
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "long_url", nullable = false)
    private String longUrl;

    @Column(name = "title", nullable = false)
    private String title;

    public ShortUrl(Integer id) {
        this.id = id;
    }
}
