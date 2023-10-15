package acme.taurant.realm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
  name = "basicAuth",
  type = SecuritySchemeType.HTTP,
  scheme = "basic"
)
@OpenAPIDefinition(
  info = @Info(
    title = "Coding Standards and Conventions",
    version = "2.0"
  ),
  security = @SecurityRequirement(name = "basicAuth")
)
public class OpenAPISecurityScheme {

}
