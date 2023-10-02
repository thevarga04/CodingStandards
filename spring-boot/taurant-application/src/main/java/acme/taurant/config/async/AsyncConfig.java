package acme.taurant.config.async;

import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {

  private static final int PROCESSORS = Math.max(1, Runtime.getRuntime().availableProcessors() - 1);
  private static final int CORE_POOL_SIZE = PROCESSORS;
  private static final int QUEUE_CAPACITY = PROCESSORS;
  private static final int MAX_POOL_SIZE = 1_000;
  private static final int KEEP_ALIVE_SECONDS = (int) Duration.ofMinutes(15).toSeconds();
  private static final boolean ALLOW_CORE_THREAD_TIME_OUT = true;


  @Bean
  @HPPooledExecutor
  public ThreadPoolTaskExecutor highPerformancePooledExecutor() {
    final var threadNamePrefix = "PooledExecutor-";

    final var executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(CORE_POOL_SIZE);
    executor.setQueueCapacity(QUEUE_CAPACITY);
    executor.setMaxPoolSize(MAX_POOL_SIZE);
    executor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
    executor.setAllowCoreThreadTimeOut(ALLOW_CORE_THREAD_TIME_OUT);
    executor.setThreadNamePrefix(threadNamePrefix);
    executor.afterPropertiesSet();
    return executor;
  }

}
