package acme.taurant.realm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
public class BasicAuthentication {


  @Bean
  public AuthenticationEntryPoint basicAuthenticationEntryPoint() {
    final var authenticationEntryPoint = new BasicAuthenticationEntryPoint();
    authenticationEntryPoint.setRealmName("SomeRealm");
    return authenticationEntryPoint;
  }

}
