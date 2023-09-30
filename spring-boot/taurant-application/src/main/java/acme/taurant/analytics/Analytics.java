package acme.taurant.analytics;

import acme.taurant.openapi.v2.model.SeatingBooking;

public interface Analytics {

  void dispatch(SeatingBooking seatingBooking);

}
