package acme.analytics;

import acme.openapi.v2.model.SeatingBooking;

public interface Analytics {

  void dispatch(SeatingBooking seatingBooking);

}
