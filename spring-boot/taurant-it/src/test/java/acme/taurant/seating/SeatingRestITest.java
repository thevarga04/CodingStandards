package acme.taurant.seating;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import acme.taurant.common.AbstractTest;
import acme.taurant.common.ObjectFactory;
import acme.taurant.openapi.v2.spring.SeatingApiController;
import acme.taurant.seating.booking.SeatingBookingService;
import acme.taurant.seating.cleaning.SeatingCleaningService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SeatingApiController.class)
@Import(SeatingRest.class)
class SeatingRestITest extends AbstractTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  SeatingBookingService seatingBookingService;

  @MockBean
  SeatingCleaningService seatingCleaningService;


  @Test
  void seatingBookingInRestaurant() throws Exception {
    // Given
    var given = ObjectFactory.createSeatingBooking();

    // When
    when(seatingBookingService.seatingBookingInRestaurant(any())).thenReturn(given);
    POST("/api/v2/seating/booking", given)
      .andExpect(status().isOk());
  }


}