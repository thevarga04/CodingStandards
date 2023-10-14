package acme.taurant.realm;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final AuthenticationEntryPoint basicAuthenticationEntryPoint;


  @Bean
  public CorsRegistry corsRegistry() {
    var corsRegistry = new CorsRegistry();
    corsRegistry.addMapping("/**").allowedMethods("*");
    return corsRegistry;
  }


  @Bean
  public SecurityFilterChain filterChainApiRealm(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
      .csrf(AbstractHttpConfigurer::disable)
      .securityMatcher(antMatcher("/api/**"))
      .authorizeHttpRequests(registry -> registry
        .anyRequest()
        .authenticated()
      )
      .httpBasic(httpBasic -> httpBasic
        .authenticationEntryPoint(basicAuthenticationEntryPoint)
      )
      .build();
  }


}
