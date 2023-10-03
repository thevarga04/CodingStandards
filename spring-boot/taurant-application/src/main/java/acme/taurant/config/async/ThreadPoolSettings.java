package acme.taurant.config.async;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
@PropertySource("classpath:async.properties")
@ConfigurationProperties("thread-pool")
@Validated
@Data
public class ThreadPoolSettings {

  @Min(1)
  private int maxPoolSize;

  @Min(1)
  private int keepAliveSeconds;

  private boolean allowCoreThreadTimeOut;

  @Size(min = 3)
  private String threadNamePrefix;

}
