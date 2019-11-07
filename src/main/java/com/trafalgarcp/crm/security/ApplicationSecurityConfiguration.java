package com.trafalgarcp.crm.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfiguration {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/","index","/css/*","/images/*","/js/*","/vendors/*").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic();
//	}
//
//    @Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("fpmoles").password("password").roles("USER","ADMIN").build());
//		users.add(User.withDefaultPasswordEncoder().username("jdoe").password("foobar").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}
//	
	
	
	
	
}


//@Configuration
//@EnableWebSecurity
//public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/","index","/css/*","/images/*","/js/*","/vendors/*").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic();
//	}
//
//  @Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("fpmoles").password("password").roles("USER","ADMIN").build());
//		users.add(User.withDefaultPasswordEncoder().username("jdoe").password("foobar").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}
//	
//	
//	
//	
//	
//}
