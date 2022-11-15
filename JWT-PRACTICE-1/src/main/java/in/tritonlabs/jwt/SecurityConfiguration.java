package in.tritonlabs.jwt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	DataSource dataSource;
	
	//PasswordEncoder en = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("azeem")
			.password(encoder().encode("12345"))
			.roles("USER")
			.and()
			.withUser("jabar")
			.password(encoder().encode("123456"))
			.roles("ADMIN");	
	
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		    .antMatchers("/admin").hasRole("ADMIN")
		    .antMatchers("/h2-console").hasRole("ADMIN")
		    .antMatchers("/user").hasAnyRole("ADMIN","USER")
		    .antMatchers("/").permitAll()
		    .and().formLogin();
	}
	


}
