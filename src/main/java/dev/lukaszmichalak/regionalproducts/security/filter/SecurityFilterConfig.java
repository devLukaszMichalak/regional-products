package dev.lukaszmichalak.regionalproducts.security.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityFilterConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    return http.csrf(Customizer.withDefaults())
        .authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers("/register", "/*/register", "/login", "/*/login")
                    .anonymous()
                    .requestMatchers(HttpMethod.POST, "/rating")
                    .authenticated()
                    .anyRequest()
                    .permitAll())
        .exceptionHandling(
            exception ->
                exception
                    .authenticationEntryPoint(new LangAuthenticationEntryPoint())
                    .accessDeniedHandler(new LangAccessDeniedHandler()))
        .formLogin(
            formLogin ->
                formLogin
                    .loginPage("/login")
                    .successHandler(new LangLoginSuccessHandler())
                    .failureHandler(new LangLoginFailureHandler()))
        .logout(
            logout ->
                logout.logoutUrl("/logout").logoutSuccessHandler(new LangLogoutSuccessHandler()))
        .build();
  }
}
