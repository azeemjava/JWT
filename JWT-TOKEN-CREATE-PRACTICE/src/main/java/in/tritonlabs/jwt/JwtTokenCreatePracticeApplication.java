package in.tritonlabs.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("in.tritonlabs.jwt")
@EntityScan("in.tritonlabs.jwt.entity")
@EnableJpaRepositories("in.tritonlabs.jwt.repository")
public class JwtTokenCreatePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenCreatePracticeApplication.class, args);
	}

}
