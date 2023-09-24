package acme.realm.config.aop;

import acme.aop.PerformanceLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Profile("PerformanceLogging")
public class PerformanceLogConfig {

  @Bean
  public PerformanceLog performanceLog() {
    return new PerformanceLog();
  }


}
