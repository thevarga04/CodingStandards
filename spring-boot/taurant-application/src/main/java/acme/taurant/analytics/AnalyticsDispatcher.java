package acme.taurant.analytics;

import acme.taurant.openapi.v2.model.SeatingBooking;

public interface AnalyticsDispatcher {


  /**
   * The interface JavaDoc should define the contract of the method.
   * What the method should do, inputs, return value, and what it should do in cases of error.
   *
   * @param seatingBooking Seating Booking
   */
  void dispatch(SeatingBooking seatingBooking);

}
