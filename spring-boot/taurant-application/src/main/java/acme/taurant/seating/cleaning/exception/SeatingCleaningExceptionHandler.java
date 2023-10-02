package acme.taurant.seating.cleaning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SeatingCleaningExceptionHandler {


  @ExceptionHandler(SeatingCleaningException.class)
  public ResponseEntity<String> seatingCleaningException(SeatingCleaningException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getClass().getSimpleName());
  }

}
