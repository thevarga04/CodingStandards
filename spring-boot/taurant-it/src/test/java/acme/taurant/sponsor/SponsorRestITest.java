package acme.taurant.sponsor;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import acme.taurant.common.AbstractTest;
import acme.taurant.common.JpaObjectFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@WebMvcTest(SponsorRest.class)
@ActiveProfiles("Sponsor")
class SponsorRestITest extends AbstractTest {

  @MockBean
  RestaurantRepo restaurantRepo;

  @MockBean
  SeatingRepo seatingRepo;

  @MockBean
  ClientRepo clientRepo;


  @Test
  void getSeatings() throws Exception {
    // Given
    var jpaSeating = JpaObjectFactory.createJpaSeating();
    var givenList = List.of(jpaSeating);

    // When
    when(seatingRepo.findAll()).thenReturn(givenList);
    GET("/api/v2/realm/seatings")
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.length()").value(1))
      .andExpect(jsonPath("$[0].id").value(1))
      .andExpect(jsonPath("$[0].restaurant.id").value(1))
    ;
  }


}