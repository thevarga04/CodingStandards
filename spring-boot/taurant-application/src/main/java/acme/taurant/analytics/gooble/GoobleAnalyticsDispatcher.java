package acme.taurant.analytics.gooble;

import acme.taurant.openapi.v2.model.SeatingBooking;
import org.springframework.stereotype.Component;

@Component
public class GoobleAnalyticsDispatcher implements GoobleAnalytics {


  /**
   * For demonstration purposes only
   */
  @Override
  public void dispatch(SeatingBooking seatingBooking) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

}
