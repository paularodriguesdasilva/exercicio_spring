package br.com.dh.exercicioempresa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select email, senha, habilitado " + 
			"from funcionario " +
			"where email = ?")
			.authoritiesByUsernameQuery("select email, autoridade " +
			"from autorizacao " +
			"where email = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/funcionario").hasAnyRole("GERENTE", "VEND")
			.antMatchers(HttpMethod.POST, "/funcionario").hasRole("GERENTE")
			.antMatchers(HttpMethod.PUT, "/funcionario").hasRole("GERENTE")
			.antMatchers(HttpMethod.DELETE, "/funcionario").hasRole("GERENTE")
			.antMatchers("/").permitAll()
			.and().httpBasic();
	}
}
