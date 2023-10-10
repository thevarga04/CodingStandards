package acme.taurant.config.async;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@ExtendWith(MockitoExtension.class)
class AsyncConfigTest {

  @Mock
  ThreadPoolSettings ThreadPoolSettings;

  @InjectMocks
  AsyncConfig sut;

  private static final int PROCESSORS = Math.max(1, Runtime.getRuntime().availableProcessors() - 1);
  private static final int CORE_POOL_SIZE = PROCESSORS;
  private static final int QUEUE_CAPACITY = PROCESSORS;
  private static final int MAX_POOL_SIZE = 1_000;
  private static final int KEEP_ALIVE_SECONDS = (int) Duration.ofMinutes(15).toSeconds();
  private static final boolean ALLOW_CORE_THREAD_TIME_OUT = true;
  private static final String THREAD_NAME_PREFIX = "PooledExecutor-";


  @BeforeEach
  void setUp() {
    sut = new AsyncConfig(ThreadPoolSettings);
  }


  @Test
  void threadPoolTaskExecutor() {
    // When
    when(ThreadPoolSettings.getMaxPoolSize()).thenReturn(MAX_POOL_SIZE);
    when(ThreadPoolSettings.getKeepAliveSeconds()).thenReturn(KEEP_ALIVE_SECONDS);
    when(ThreadPoolSettings.isAllowCoreThreadTimeOut()).thenReturn(ALLOW_CORE_THREAD_TIME_OUT);
    when(ThreadPoolSettings.getThreadNamePrefix()).thenReturn(THREAD_NAME_PREFIX);
    var actual = sut.threadPoolTaskExecutor();

    // Then
    assertThat(actual).isNotNull()
      .extracting(
        ThreadPoolTaskExecutor::getCorePoolSize
        , ThreadPoolTaskExecutor::getQueueCapacity
        , ThreadPoolTaskExecutor::getMaxPoolSize
        , ThreadPoolTaskExecutor::getKeepAliveSeconds
        , ThreadPoolTaskExecutor::getThreadNamePrefix
      )
      .containsExactly(
        CORE_POOL_SIZE
        , QUEUE_CAPACITY
        , MAX_POOL_SIZE
        , KEEP_ALIVE_SECONDS
        , THREAD_NAME_PREFIX
      );
  }

}
