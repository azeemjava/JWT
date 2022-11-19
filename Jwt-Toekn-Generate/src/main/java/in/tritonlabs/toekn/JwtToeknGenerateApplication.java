package in.tritonlabs.toekn;

import javax.persistence.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("in.tritonlabs.toekn")
public class JwtToeknGenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtToeknGenerateApplication.class, args);
	}

}
