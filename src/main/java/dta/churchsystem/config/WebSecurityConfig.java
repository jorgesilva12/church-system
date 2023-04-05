package dta.churchsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security)throws Exception{
        security
//                .httpBasic()
                .formLogin()
                .and()
                .authorizeRequests()
                    .requestMatchers("/").permitAll()
                    .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return security.build();
    }

    @Bean
    public PasswordEncoder passwordEcnoder() {
        return new BCryptPasswordEncoder();
    }
}
