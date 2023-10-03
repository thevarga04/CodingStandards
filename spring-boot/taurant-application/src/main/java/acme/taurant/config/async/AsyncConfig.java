package acme.taurant.config.async;

import static java.lang.Runtime.getRuntime;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@RequiredArgsConstructor
public class AsyncConfig {

  private final ThreadPoolSettings threadPoolSettings;


  @Bean
  @PooledExecutor
  public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
    var processors = Math.max(1, getRuntime().availableProcessors() - 1);

    final var executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(processors);
    executor.setQueueCapacity(processors);
    executor.setMaxPoolSize(threadPoolSettings.getMaxPoolSize());
    executor.setKeepAliveSeconds(threadPoolSettings.getKeepAliveSeconds());
    executor.setAllowCoreThreadTimeOut(threadPoolSettings.isAllowCoreThreadTimeOut());
    executor.setThreadNamePrefix(threadPoolSettings.getThreadNamePrefix());
    executor.afterPropertiesSet();
    return executor;
  }

}
