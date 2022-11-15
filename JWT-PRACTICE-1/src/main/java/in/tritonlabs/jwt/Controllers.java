package in.tritonlabs.jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

	
	@GetMapping("/")
	public String get1() {
		return "all";
	}
	

	@GetMapping("/user")
	public String get2() {
		return "user only";
	}
	

	@GetMapping("/admin")
	public String get3() {
		return "admin only";
	}
	
	
	
}
