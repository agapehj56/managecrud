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
			.antMatchers("/country/**").hasRole("ADMIN")			// 로그인을 해야만 페이지로 들어갈 수 있게끔 하는 페이지 제한 줌.
//			.antMatchers("/city/**").hasRole("ADMIN")
			.antMatchers("/city/register").hasRole("ADMIN")
			.antMatchers("/city/modify/**").hasRole("ADMIN")
			.antMatchers("/city/unregister/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll();
	}	// 메소드 체인 방식으로 서술됨.
}
