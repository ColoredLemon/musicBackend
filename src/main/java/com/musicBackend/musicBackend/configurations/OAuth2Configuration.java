package com.musicBackend.musicBackend.configurations;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class OAuth2Configuration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	  http
    	  .csrf().disable()
          .antMatcher("/**")
          .authorizeRequests()
          
          .antMatchers("/", "/style/*","/images/*","/musics/*","/login**", "/webjars/**", "/error**")
          .permitAll()
          .anyRequest()
          .authenticated()
          .and()
          
          
       
          
          
          ;
    	
    	
    	
//    	http 
//    	.antMatcher("/**")
//    	.authorizeRequests()
//    	.anyRequest().authenticated()
//    	
                
                
                }
    
}

