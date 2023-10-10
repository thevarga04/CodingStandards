package acme.taurant.seating;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import acme.taurant.common.AbstractTest;
import acme.taurant.common.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("Sponsor")
class SeatingBookingE2ETest extends AbstractTest {


  void create2Restaurants() throws Exception {
    // When
    POST("/api/v2/realm/restaurants")
      .andExpect(status().isOk());

    POST("/api/v2/realm/restaurants")
      .andExpect(status().isOk());
  }

  void createClient() throws Exception {
    POST("/api/v2/realm/clients")
      .andExpect(status().isOk());
  }

  void createSeating() throws Exception {
    POST("/api/v2/realm/seatings")
      .andExpect(status().isOk());
  }


  @Test
  void createSeatingBookingIn2ndRestaurant() throws Exception {
    // Given
    create2Restaurants();
    createClient();
    createSeating();
    var given = ObjectFactory.createSeatingBooking();

    // When
    POST("/api/v2/seating/booking", given)
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").value(1));
  }


}