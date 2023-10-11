package acme.taurant.seating;

import static acme.taurant.common.ObjectFactory.createSeatingBooking;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import acme.taurant.common.AbstractTest;
import acme.taurant.openapi.v2.spring.SeatingApiController;
import acme.taurant.seating.booking.SeatingBookingService;
import acme.taurant.seating.cleaning.SeatingCleaningService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@WebMvcTest(SeatingApiController.class)
@Import(SeatingRest.class)
class SeatingBookingITest extends AbstractTest {

  @MockBean
  SeatingBookingService seatingBookingService;

  @MockBean
  SeatingCleaningService seatingCleaningService;


  @Test
  void seatingBookingInRestaurant() throws Exception {
    // Given
    var given = createSeatingBooking(0);
    var saved = createSeatingBooking(1);

    // When
    when(seatingBookingService.seatingBookingInRestaurant(any())).thenReturn(saved);
    POST("/api/v2/seating/booking", given)
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").value(1))
    ;
  }


}