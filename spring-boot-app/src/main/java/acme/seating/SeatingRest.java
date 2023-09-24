package acme.seating;

import acme.openapi.v2.model.SeatingBooking;
import acme.openapi.v2.model.SeatingCleaning;
import acme.openapi.v2.spring.SeatingApiDelegate;
import acme.seating.booking.SeatingBookingService;
import acme.seating.cleaning.SeatingCleaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SeatingRest implements SeatingApiDelegate {

  private final SeatingBookingService seatingBookingService;
  private final SeatingCleaningService seatingCleaningService;


  @Override
  public ResponseEntity<SeatingBooking> seatingBookingInRestaurant(SeatingBooking seatingBooking) {
    return ResponseEntity.ok(seatingBookingService.seatingBookingInRestaurant(seatingBooking));
  }

  @Override
  public ResponseEntity<SeatingCleaning> seatingCleaningInRestaurant(SeatingCleaning seatingCleaning) {
    return ResponseEntity.ok(seatingCleaningService.seatingCleaningInRestaurant(seatingCleaning));
  }

}
