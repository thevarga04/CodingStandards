package acme.taurant.realm.config;

import acme.taurant.seating.booking.SeatingBookingPreoccupiedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

  @ExceptionHandler(SeatingBookingPreoccupiedException.class)
  public ResponseEntity<String> userValidatorException(SeatingBookingPreoccupiedException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getClass().getSimpleName());
  }

}
