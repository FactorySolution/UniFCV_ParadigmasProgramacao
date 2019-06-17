package br.edu.unifcv.faculdade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final String[] ROLES = { "API", "USER" };

	private static final String[] AUTH_WHITELIST = { 
			"/swagger-resources/**", 
			"/swagger-ui.html", 
			"/v2/api-docs",
			"/webjars/**" };

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password(passwordEncoder.encode("123mudar"))
			.roles(ROLES);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/h2-console/**")
			.permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}

}
