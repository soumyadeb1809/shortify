package in.soumyadeb.shortify.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("in.soumyadeb.shortify")
public class ShortifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortifyApplication.class, args);
	}

}
