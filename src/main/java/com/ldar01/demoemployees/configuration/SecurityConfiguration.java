package com.ldar01.demoemployees.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)-> csrf.disable() )
                .authorizeHttpRequests((authorizeRequests) -> {
                    authorizeRequests
                            /*.requestMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.GET, "/api/employee/**").hasRole("USER")*/
                            .anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults() );
                return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("test"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
