package acme.taurant.seating;

import static org.springframework.http.HttpStatus.CREATED;

import acme.taurant.openapi.v2.model.SeatingBooking;
import acme.taurant.openapi.v2.model.SeatingCleaning;
import acme.taurant.openapi.v2.spring.SeatingApiDelegate;
import acme.taurant.seating.booking.SeatingBookingService;
import acme.taurant.seating.cleaning.SeatingCleaningService;
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
    return ResponseEntity.status(CREATED).body(seatingBookingService.seatingBookingInRestaurant(seatingBooking));
  }

  @Override
  public ResponseEntity<SeatingCleaning> seatingCleaningInRestaurant(SeatingCleaning seatingCleaning) {
    return ResponseEntity.status(CREATED).body(seatingCleaningService.seatingCleaningInRestaurant(seatingCleaning));
  }

}
