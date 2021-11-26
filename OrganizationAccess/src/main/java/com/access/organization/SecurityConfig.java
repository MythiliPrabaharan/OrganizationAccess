package com.access.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception 
	{
		httpSecurity.csrf().disable().authorizeRequests()
				.anyRequest().authenticated()
				.and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);
		
		httpSecurity.headers().frameOptions().disable();
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("adminuser").password("adminpassword").roles("USER");
	}
}
