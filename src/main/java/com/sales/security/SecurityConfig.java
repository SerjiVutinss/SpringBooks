package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
//		https://www.baeldung.com/spring-security-logout
		httpSecurity.authorizeRequests().antMatchers("/showBooks", "/showCustomers", "/showLoans", "/addBook",
				"/addCustomer", "/newLoan", "/deleteLoan").hasRole("USER").and().formLogin().and().logout();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
}