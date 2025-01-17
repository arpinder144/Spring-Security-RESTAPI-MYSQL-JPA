package com.example.springpractice.config;

import com.example.springpractice.model.MyUserDetails;
import com.example.springpractice.model.UserInfo;
import com.example.springpractice.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserInfoConfig {
    @Autowired
    MyUserDetailsService myUserDetailsService;

   @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests((req)->req.requestMatchers("/home/register")
                       .permitAll()
                       .anyRequest()
                       .authenticated())
               .httpBasic(Customizer.withDefaults())
               .formLogin(Customizer.withDefaults())

       ;

       return http.build();
   }

   @Bean
   public AuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
       daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
       return daoAuthenticationProvider;
   }


}
