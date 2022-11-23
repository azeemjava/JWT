package in.tritonlabs.jwt.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.tritonlabs.jwt.entity.Register;
import in.tritonlabs.jwt.repository.RegisterRepository;

@Service
public class CustomizeUserDetailService implements UserDetailsService {
	
	@Autowired
	RegisterRepository registerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    	final Register register = registerRepo.findByEmail(username);
        
        if (register == null) {
        	
            throw new UsernameNotFoundException(username);
        }
       UserDetails user = User.withUsername(register.getEmail()).password(register.getPassword()).authorities(register.getRole()).build();
       return user;
        
       
       //return new User(register. getEmail(),register.getPassword(),register.getRoles()); - This is used to role on list or set.

       
    }
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return request.getRequestURI().startsWith("/login");
	}

}
