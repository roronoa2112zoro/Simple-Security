package org.home.workspace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configureUser(AuthenticationManagerBuilder authentication) throws Exception {

		authentication.inMemoryAuthentication()
		.withUser("Sahil").password("{noop}admin").roles("USER")
		.and()
		.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().fullyAuthenticated()
		.and()
		.httpBasic();
	}
}
