package in.sp.main.security;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {
	
	  @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

	        http.csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(auth -> auth
	                        .requestMatchers("/auth/register").permitAll()
	                        .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("User","admin")

	                        // ADMIN → POST PUT DELETE access
	                        .requestMatchers(HttpMethod.POST, "/**").hasRole("admin")
	                        .requestMatchers(HttpMethod.PUT, "/**").hasAnyRole("admin","User")
	                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("admin")
	                        .anyRequest().authenticated()
	                )
	                .httpBasic(Customizer.withDefaults());
	        
	        return http.build();
	    }



}
