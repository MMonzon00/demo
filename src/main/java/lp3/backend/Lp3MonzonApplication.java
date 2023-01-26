package lp3.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("lp3.backend.repository")
public class Lp3MonzonApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lp3MonzonApplication.class, args);
	}

}
