package in.tritonlabs.jwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.tritonlabs.jwt.common.ApiResponse;
import in.tritonlabs.jwt.entity.Login;
import in.tritonlabs.jwt.service.impl.LoginServiceImpl;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {

	@Autowired
	LoginServiceImpl impl;
	
	@PostMapping("/")
	public ApiResponse get(@RequestBody Login login){
		
		ApiResponse response =impl.get(login);
		
		return response;
	}
	
	@GetMapping("/{id}")
	public ApiResponse getAll(@PathVariable("id") int id){
	ApiResponse apiResponse= impl.getAll(id);
	 return apiResponse;
	}
	
}
