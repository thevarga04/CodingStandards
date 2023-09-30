package acme.taurant.analytics.facepook;

import acme.taurant.openapi.v2.model.SeatingBooking;
import org.springframework.stereotype.Component;

@Component
public class FacepookAnalyticsDispatcher implements FacepookAnalytics {


  /**
   * For demonstration purposes only
   */
  @Override
  public void dispatch(SeatingBooking seatingBooking) {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

}
