package com.svg.java.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity allow us to protect methods in backend
@EnableGlobalMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true)
public class SecurityConfigurator  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  Spring security Login by default (with its own login view)
        //http.authorizeRequests().antMatchers("/**").hasRole("administrator").and().formLogin();
        
        // Spring security Login by template
        http.csrf().disable().authorizeRequests().antMatchers("/**").hasAnyRole("administrator", "advance", "basic").and().formLogin()
        .loginPage("/login").permitAll().defaultSuccessUrl("/invoicesList", true);

        super.configure(http);
    }
    
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Authentificator in memory
        // 3 users with different roles
        auth.inMemoryAuthentication()
            .withUser("galdons").password("{noop}myPassword").roles("administrator").and()
            .withUser("basic1").password("{noop}basic1").roles("basic").and()
            .withUser("advance1").password("{noop}advance1").roles("advance");

        super.configure(auth);
    }

}
