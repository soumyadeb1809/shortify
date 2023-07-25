package in.soumyadeb.shortify.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("in.soumyadeb.shortify")
@EntityScan("in.soumyadeb.shortify.entity")
@EnableJpaRepositories("in.soumyadeb.shortify.repository")
@EnableCaching
public class ShortifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortifyApplication.class, args);
	}

}
