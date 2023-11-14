package com.eidiko.niranjana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class BasicAuthenticationSecurityConfig extends WebSecurityConfigurerAdapter
{
	public static final String[] PUBLIC_URLS = {"/v3/api-docs","/v2/api-docs","/swagger-resources/**", "/swagger-ui/**","/webjars/**"};
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.csrf().disable()
        .authorizeHttpRequests()
        .antMatchers(PUBLIC_URLS).permitAll()
		        .anyRequest()
		        .authenticated()
		        .and()
		        .httpBasic();
	}
}



