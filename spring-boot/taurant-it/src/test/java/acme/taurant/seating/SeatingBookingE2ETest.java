package acme.taurant.seating;

import static acme.taurant.common.ObjectFactory.createSeatingBooking;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import acme.taurant.common.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("Sponsor")
class SeatingBookingE2ETest extends AbstractTest {


  void createRestaurants(int amount) throws Exception {
    while (amount-- > 0) {
      POST("/api/v2/realm/restaurants")
        .andExpect(status().isCreated());
    }
  }

  void createClient() throws Exception {
    POST("/api/v2/realm/clients")
      .andExpect(status().isCreated());
  }

  void createSeating() throws Exception {
    POST("/api/v2/realm/seatings")
      .andExpect(status().isCreated());
  }


  @Test
  void createSeatingBookingIn2ndRestaurant() throws Exception {
    // Given
    createRestaurants(2);
    createClient();
    createSeating();
    var given = createSeatingBooking(0);

    // When
    POST("/api/v2/seating/booking", given)
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").value(1));
  }


}