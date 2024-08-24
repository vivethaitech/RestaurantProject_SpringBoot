package com.vivi.restaurant;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	@Bean
	public UserDetailsService userDetails(PasswordEncoder encrypt) {
		
		UserDetails user = User.withUsername("poppy")
				               .password(encrypt.encode("12345678"))
				               .roles("USER")
				               .build();
		UserDetails admin = User.withUsername("vivetha")
	               .password(encrypt.encode("12345678"))
	               .roles("ADMIN")
	               .build();
		UserDetails manager = User.withUsername("kanmani")
	               .password(encrypt.encode("12345678"))
	               .roles("MANAGER")
	               .build();
		UserDetails assManager = User.withUsername("vinith")
	               .password(encrypt.encode("12345678"))
	               .roles("ASSMANAGER")
	               .build();
		return new InMemoryUserDetailsManager(user,admin,manager,assManager);
		
	}
	@Bean
	public PasswordEncoder pe() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
	    return http
	        .csrf().disable()
	        .authorizeHttpRequests()
	        .requestMatchers("/Kanmani/restaurant/food/get").permitAll()
	        .requestMatchers("/Kanmani/restaurant/food/add").authenticated()
	        .requestMatchers("/Kanmani/restaurant/food/delete/{foodName}").authenticated()
	        .requestMatchers("/Kanmani/restaurant/food/update/{id}").authenticated()
	        .and()
	        .httpBasic()
	        .and()
	        .build();
	}

}
