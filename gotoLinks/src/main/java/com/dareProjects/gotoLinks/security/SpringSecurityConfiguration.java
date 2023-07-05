package com.dareProjects.gotoLinks.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailManager() {
		
		
		UserDetails userDetails1 = getUserDetails("dhruv@gmail.com", "dhruv");
		UserDetails userDetails2 = getUserDetails("Arpit", "parekh");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//				.username("Dhruv")
//				.password("dummy")
//				.roles("USER","ADMIN")
//				.build();
		
	}

	private UserDetails getUserDetails(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
								.passwordEncoder(passwordEncoder)
								.username(username)
								.password(password)
								.roles("ADMIN", "USER")
								.build();
		return userDetails;
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//by default in spring security
	//all frames are protected
	//a loginf form is shown for all unauthorised requests
	//CSRF are disabled 
	//frames are disabled || need to be enabled.
	
	
	//following is needed to use h2 console. check the import static statement for withDefaults() among the imports it is
	//required for following to work
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
		
	}
	

}
