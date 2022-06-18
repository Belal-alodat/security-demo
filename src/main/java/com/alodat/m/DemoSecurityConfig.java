package com.alodat.m;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SecurityFilterChain getFilter(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers("/login","/users/authenticate", "/users/register").permitAll();
		http.authorizeRequests().antMatchers("/user1").hasRole("USER2");
		http.authorizeRequests().antMatchers("/user2").hasRole("USER3");
		http.authorizeRequests().anyRequest().authenticated();
		//http.sessionManagement().sessionCreationPolicy();
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.formLogin();
		 
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService getOdatAuthinticationSecurity() {
		
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return User.withUsername("user1").password("user1").roles("USER1","USER2").build();
			}
			
		};
	}
	
	
	
}
