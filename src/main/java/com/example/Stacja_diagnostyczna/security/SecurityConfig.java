package com.example.Stacja_diagnostyczna.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select Email,Password ,enabled from Diagnosta where Email=?")
                .authoritiesByUsernameQuery("select Email, Role from Diagnosta where Email=?")
        ;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/", "/reserve-service/{id}"," /reservation-confirm", "/reservation-confirm/{id}","/h2-console/**", "/css/*","/js/*")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .loginProcessingUrl("/login").defaultSuccessUrl("/reservations")
                .failureUrl("/login?error=true")
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin()
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true).permitAll();
    }
}

