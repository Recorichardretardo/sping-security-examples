package com.example.basic.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
public class SecurityCustomConfig extends WebSecurityConfigurerAdapter {
	
	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomAutheticationProvider customAutheticationProvider;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager userDetailesService = new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("test").password(passwordEncoder.encode("password")).authorities("read").build();
//		userDetailesService.createUser(user);
//		auth.userDetailsService(userDetailesService).passwordEncoder(passwordEncoder);
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAutheticationProvider);
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeHttpRequests()
//			.antMatchers("/api/test","/api/test-third").permitAll()
//			.antMatchers("/api/test-second").authenticated()
//			.anyRequest().authenticated();
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeHttpRequests()
			.antMatchers("/api/test","/api/test-third").permitAll()
			.antMatchers("/api/test-second").authenticated()
			.antMatchers("/api/test-fourth").denyAll()
			.anyRequest().authenticated();
		http.addFilterBefore(new CustomSecurityFilter(), BasicAuthenticationFilter.class);
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
