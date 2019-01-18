package com.example.springboot.configuration;

import com.example.springboot.model.user.User;
import com.example.springboot.service.auth.AuthService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class AuthConfigurer extends WebSecurityConfigurerAdapter {
  @Autowired
  private AuthService authService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    ArrayList<String> publicUrls = new ArrayList<>();
    publicUrls.addAll(Arrays.asList(
            "/",
            "/bundle.js",
            "/bundle.js.map",
            "/images/*",
            "/api/*/auth"));

    http
      .csrf().disable()
      .headers().cacheControl().disable()
      .and()
      .authorizeRequests()
      .antMatchers(publicUrls.toArray(new String[publicUrls.size()])).permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .successHandler((req, res, auth) -> { })
      .failureHandler((req, res, ex) -> {
        res.getWriter().append("Unauthorized");
        res.setStatus(401);
      })
    .and()
      .logout()
      .logoutSuccessHandler((req, res, auth) -> authService.logout());

  }

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return auth -> {
      User user = authService.login(auth.getPrincipal().toString(),
                                    auth.getCredentials().toString());

      if (user == null) {
        throw new BadCredentialsException("login failed!");
      }

      return new UsernamePasswordAuthenticationToken(
        auth.getPrincipal(),
        auth.getCredentials(),
        user.getRoles().stream().map(
          r -> new SimpleGrantedAuthority(
            r.name())).collect(Collectors.toList()));
    };
  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    return new UserDetailsManager() {

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return org.springframework.security.core.userdetails.User
          .withUsername(username).build(); // TODO / REVIEW
      }

      @Override public boolean userExists(String username) {
        return true; // TODO / REVIEW
      }

      @Override public void createUser(UserDetails user) {}

      @Override public void updateUser(UserDetails user) {}

      @Override public void deleteUser(String username) {}

      @Override public void changePassword(String oldPassword, String newPassword) {}
    };
  }
}
