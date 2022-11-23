package in.tritonlabs.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("in.tritonlabs.jwt")
public class SpringScurityUserDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringScurityUserDetailApplication.class, args);
	}

}
