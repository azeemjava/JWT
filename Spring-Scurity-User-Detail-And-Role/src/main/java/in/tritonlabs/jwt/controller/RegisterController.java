package in.tritonlabs.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

	
	@GetMapping("/admin")
	public String getAll() {
		
		return "admin";
	}
	@GetMapping("/home")
	public String getAll1() {
		
		return "home";
	}
	@GetMapping("/hello")
	public String getAll2() {
		
		return "hello";
	}
}
