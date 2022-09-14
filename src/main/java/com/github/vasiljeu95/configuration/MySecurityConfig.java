package com.github.vasiljeu95.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * MySecurityConfig
 *
 * @author Stepan Vasilyeu
 * @since 13.09.2022
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hrInfo").hasRole("HR")
                .antMatchers("/managerInfo/**").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("stepan").password("s1234").roles("EMPLOYEE"))
                .withUser(userBuilder.username("kate").password("k1234").roles("HR"))
                .withUser(userBuilder.username("stepanBoss").password("boss1234").roles("MANAGER", "HR"));


    }
}
