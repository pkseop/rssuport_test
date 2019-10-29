package test.rsupport.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import test.rsupport.service.CustomUserDetailService;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailService customUserDetailService;
	
	 /* Security 제외 패턴 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring()
		.antMatchers("/test_db/**", "/libs/**",
				"/js/**", "/css/**");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/board")
                .and()
                .logout().permitAll().logoutSuccessUrl("/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
 	@Autowired
 	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
 		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
 	}

}
