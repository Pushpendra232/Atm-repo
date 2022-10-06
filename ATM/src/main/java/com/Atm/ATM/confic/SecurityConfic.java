package com.Atm.ATM.confic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfic extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        
    }
    
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws
      Exception {
      auth.inMemoryAuthentication().withUser("pankaj").password("pankaj1234").roles("NORMAL");
      auth.inMemoryAuthentication().withUser("admin").password("pankaj1234").roles("ADMIN");
      
      }
      
      
      @Bean
      public PasswordEncoder passwordEncoder() {
      
      return NoOpPasswordEncoder.getInstance();
      
      }
     
     
}