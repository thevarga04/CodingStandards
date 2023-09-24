package acme.seating.cleaning;

import acme.openapi.v2.model.SeatingCleaning;

public interface SeatingCleaningService {

  /**
   * The interface JavaDoc should define the contract of the method.
   * What the method should do, inputs, return value, and what it should do in cases of error.
   *
   * @param seatingCleaning Seating Booking
   * @return Newly created resource
   */
  SeatingCleaning seatingCleaningInRestaurant(SeatingCleaning seatingCleaning);

}
