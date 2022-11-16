package in.tritonlabs.jwt.util;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import in.tritonlabs.jwt.entity.Login;
import in.tritonlabs.jwt.repository.ILoginRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	@Autowired
	ILoginRepository repo;
	
	static long expiryDuraion = 010*010; 
	
	static String secret ="java"; 

	
	public String generateJwtToken(Login login) {
		
		
	// Get Particular Person Details	
	Optional<Login> getLogin = repo.findById(login.getId());
	Login loginDetails = getLogin.get();
   
	//Create Current Time
    long milliTime = System.currentTimeMillis();
    
    //Calculate Time 
	long expiryTime =milliTime  + expiryDuraion *1000;

		
	    // Generate Date	
		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);

		// Create Claims 
		Claims claims = Jwts.claims()
							.setIssuer(String.valueOf(login.getId()))
							.setIssuedAt(issuedAt)
							.setExpiration(expiryAt);


		// Set Details That Claims
		claims.put("NAME", loginDetails.getName());
		claims.put("EMAIL", loginDetails.getEmail());
		claims.put("PHONE", loginDetails.getPh());


		
		// Generate JWT Token ID And Set Secret
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,secret ).compact();

	}

}
