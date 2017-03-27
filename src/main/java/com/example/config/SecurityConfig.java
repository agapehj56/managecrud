package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * 인증
		 */
		auth.inMemoryAuthentication()
			.withUser("admin").password("1234").roles("ADMIN")
			.and()
			.withUser("user").password("1234").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * 권한
		 */
		http.csrf().disable()			// 보안때문에 뜨지 않았던 로그아웃을 보안부분을 안보이게 해서 로그아웃 되게끔 함.
			.authorizeRequests()
			.antMatchers("/country/**").hasRole("ADMIN")
//			.antMatchers("/city/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.permitAll();
	}
}
