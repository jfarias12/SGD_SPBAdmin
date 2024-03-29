/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.sgdadmin;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.company.sgdadmin.repository.LoginRepository;
import javax.ws.rs.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author the_d
 */
@Configuration
@EnableAutoConfiguration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    LoginRepository loginRepository;

    @Value("select usuario as username, contrasena as password, estatus as enabled from usuario where usuario=?")
    private String userQuery;

    @Value("select u.usuario as username, r.nombre as authority from usuario u join rol r on(u.rol_id = r.rol_id) where u.usuario = ? ")
    private String roleQuery;

    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(roleQuery)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/vendor/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fullcalendar/**").permitAll()
                .antMatchers("/menu").hasAnyRole("USER", "ADMIN")
                .antMatchers("/listausuarios").hasAnyRole("USER", "ADMIN")
                .antMatchers("/nuevousuario").hasAnyRole("USER", "ADMIN")
                .antMatchers("/registro").hasAnyRole("USER", "ADMIN")
                .antMatchers("/administradorusuarios").hasAnyRole("USER", "ADMIN")
                .antMatchers("/cargaarchivos").hasAnyRole("USER", "ADMIN")
                .antMatchers("/upload").hasAnyRole("USER", "ADMIN")
                .antMatchers("/js").hasAnyRole("USER", "ADMIN")
                .antMatchers("/selectdinamico").hasAnyRole("USER", "ADMIN")
                .antMatchers("/editarcifras").hasAnyRole("USER", "ADMIN")
                .antMatchers("/registrocifra").hasAnyRole("USER", "ADMIN")
                .antMatchers("/listaarchivos").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getDocto").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index").failureUrl("/500")
                .permitAll()
                .defaultSuccessUrl("/menu", true)
                .and()
                .logout()
                .permitAll()
                .clearAuthentication(true);

        http
                .formLogin()
                .permitAll().and().sessionManagement().maximumSessions(1);

        http
                .headers()
                .contentTypeOptions()
                .and()
                .xssProtection()
                .and()
                .cacheControl()
                .and()
                .httpStrictTransportSecurity()
                .and()
                .frameOptions();

        http
                .exceptionHandling()
                .accessDeniedPage("/403");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}