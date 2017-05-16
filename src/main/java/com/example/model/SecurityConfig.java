package com.example.model;

import com.example.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Rudyard Moreno on 4/18/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic();
        http.authorizeRequests().mvcMatchers("/lessons/**", "/users/**","/words/**","/flights/**", "/math/**","/**").permitAll();
        http.authorizeRequests().mvcMatchers("/admin/**").hasAnyRole("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(employeeDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("employee").password("my-employee-password").roles("EMPLOYEE")
                .and()
                .withUser("boss").password("my-boss-password").roles("MANAGER")
                .and()
                .withUser("admin").password("my-admin-password").roles("ADMIN");
    }*/
}
