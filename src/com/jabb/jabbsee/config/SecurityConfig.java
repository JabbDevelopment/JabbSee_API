package com.jabb.jabbsee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import com.jabb.jabbsee.service.UserAuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	private UserAuthService userAuthService;
	
	@Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userAuthService); 
    }
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider
	      = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userAuthService);
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}
	 
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder(16);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println("SecurityConfig. Configure-WEB.");
		
		web
			.ignoring()
			.antMatchers("/register");
			
		
		//web.debug(true);
	}
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		 System.out.println("SecurityConfig. Configure-HTTP.");
		 
	    http
	      .httpBasic()
	    .and()
	      	.authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/library").authenticated()
	        .antMatchers(HttpMethod.PUT, "/library").authenticated()
	        .antMatchers(HttpMethod.DELETE, "/library").authenticated()
	    .and()
	      	.csrf().disable();
	    	
    		
	    
	  }
	
	

}
