/**
 * Created by IntelliJ IDEA.
 * User: DatNH5
 * Date: 7/23/2018
 * Time: 4:16 PM
 **/
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login2").permitAll()
                    .antMatchers("/hello", "/admin").hasRole("ADMIN")
                    .antMatchers("/hello", "/user").hasRole("USER")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .successForwardUrl("/hello")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    }
}
