package acme.taurant.config.async;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Marker annotation for a High Performance PooledExecutor
 */
@Documented
@Qualifier("PooledExecutor")
@Retention(RetentionPolicy.RUNTIME)
public @interface HPPooledExecutor {

}