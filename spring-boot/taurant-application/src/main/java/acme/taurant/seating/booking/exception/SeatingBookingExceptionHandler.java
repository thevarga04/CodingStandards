package acme.taurant.seating.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SeatingBookingExceptionHandler {


  @ExceptionHandler(SeatingBookingOverlappingException.class)
  public ResponseEntity<String> userValidatorException(SeatingBookingOverlappingException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getClass().getSimpleName());
  }

}
