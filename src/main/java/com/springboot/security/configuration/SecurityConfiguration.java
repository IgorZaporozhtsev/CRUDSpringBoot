package com.springboot.security.configuration;

import com.springboot.security.handlers.CustomAuthenticationSuccessHandler;
import com.springboot.security.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@ComponentScan("com.springboot")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private AuthenticationService authenticationService;

        @Autowired
        private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(authenticationService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                    http.csrf().disable();
                    http.authorizeRequests()
                    .antMatchers("/user/**").hasAnyAuthority("USER")
                    .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                    .and()
                    .formLogin()
                    .loginPage("/")
                    .successHandler(customAuthenticationSuccessHandler)
                    .usernameParameter("login")
                    .passwordParameter("password");
        }
}
