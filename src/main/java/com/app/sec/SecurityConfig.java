package com.app.sec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		 .dataSource(dataSource)
		 .usersByUsernameQuery("select userName as principal, pass as credentials, active from users where userName=?")
		 .authoritiesByUsernameQuery("select userName as principal, role as role from users_roles where userName=?")
		 .rolePrefix("ROLE_")
		 .passwordEncoder(new Md5PasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		//donne l'autorisation aux utilisateurs d'executer toutes les requêtes 
		//http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/entreprises").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveEntreprise","/formEntreprise").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	}
 
}
