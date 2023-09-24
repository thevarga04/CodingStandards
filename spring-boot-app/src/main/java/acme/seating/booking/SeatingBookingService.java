package acme.seating.booking;

import acme.openapi.v2.model.SeatingBooking;

public interface SeatingBookingService {


  /**
   * The interface JavaDoc should define the contract of the method.
   * What the method should do, inputs, return value, and what it should do in cases of error.
   *
   * @param seatingBooking Seating Booking
   * @return Newly created resource
   */
  SeatingBooking seatingBookingInRestaurant(SeatingBooking seatingBooking);

}
