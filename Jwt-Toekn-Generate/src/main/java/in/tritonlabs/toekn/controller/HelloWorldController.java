package in.tritonlabs.toekn.controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.tritonlabs.toekn.entity.detail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class HelloWorldController  {

	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}
	

	@PostMapping("user")
	public detail login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);

		detail user =new detail();
		
		if("azeem".equals(username)) {
			
		user.setUser(username);
		user.setToken(token);	
		}
		return user;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						
				grantedAuthorities.stream()
						           .map(GrantedAuthority::getAuthority)
							       .collect(Collectors.toList()))
				                   .setIssuedAt(new Date(System.currentTimeMillis()))
				                   .setExpiration(new Date(System.currentTimeMillis() + 600000))
				                   .signWith(SignatureAlgorithm.HS512,
			
			  secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}