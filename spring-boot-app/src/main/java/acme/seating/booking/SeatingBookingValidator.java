package acme.seating.booking;

import static org.springframework.util.CollectionUtils.isEmpty;

import acme.seating.booking.jpa.JpaSeatingBooking;
import java.util.List;

public class SeatingBookingValidator {


  private SeatingBookingValidator() {
  }


  public static void assertEmpty(List<JpaSeatingBooking> seatingBookingList) {
    if (!isEmpty(seatingBookingList)) {
      throw new SeatingBookingPreoccupiedException();
    }
  }

}