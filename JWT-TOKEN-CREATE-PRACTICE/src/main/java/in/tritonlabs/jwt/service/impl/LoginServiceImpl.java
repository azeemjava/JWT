package in.tritonlabs.jwt.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import in.tritonlabs.jwt.common.ApiResponse;
import in.tritonlabs.jwt.entity.Login;
import in.tritonlabs.jwt.repository.ILoginRepository;
import in.tritonlabs.jwt.util.JwtUtils;

@Service
public class LoginServiceImpl {

	@Autowired
	ILoginRepository repo;

	@Autowired
	JwtUtils jwtUtils;

	public ApiResponse get(Login login) {
		
		ApiResponse apiResponse = new ApiResponse();

		if (repo.existsById(login.getId())) {

			String token = jwtUtils.generateJwtToken(login);

		
			Map<String ,Object> data =new HashMap<>();
			data.put("AccessToken", token);
			
			apiResponse.setData(data);
			apiResponse.setStstus(HttpStatus.OK.value());
			
			
			return apiResponse;
	
		} else {

			apiResponse.setData("Does not exists");
			apiResponse.setStstus(HttpStatus.NOT_FOUND.value());

			return apiResponse;
		}

	}

	
	public ApiResponse getAll(int id){
		
		Optional<Login> getLogin = repo.findById(id);
		Login loginDetails = getLogin.get();
		
		
		ApiResponse apiResponse = new ApiResponse();
		
		HashMap<String,String > map=new HashMap<>();		
		map.put("NAME",  loginDetails.getName());
		map.put("EMAIL", loginDetails.getEmail());

		apiResponse.setData(map);
		
		return apiResponse;
		}
	
	
	
	
	
	
	
	
	
}
