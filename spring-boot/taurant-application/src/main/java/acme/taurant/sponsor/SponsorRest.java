package acme.taurant.sponsor;

import static acme.taurant.sponsor.SponsorFactory.createJpaClient;
import static acme.taurant.sponsor.SponsorFactory.createJpaRestaurant;
import static acme.taurant.sponsor.SponsorFactory.createJpaSeating;
import static acme.taurant.sponsor.SponsorMapper.toBo;
import static org.springframework.http.HttpStatus.CREATED;

import acme.taurant.openapi.v2.model.Client;
import acme.taurant.openapi.v2.model.Restaurant;
import acme.taurant.openapi.v2.model.Seating;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/realm")
@RequiredArgsConstructor
@Profile("Sponsor")
@Transactional
public class SponsorRest {

  private final RestaurantRepo restaurantRepo;
  private final SeatingRepo seatingRepo;
  private final ClientRepo clientRepo;


  @PostMapping("/restaurants")
  public ResponseEntity<Restaurant> createRestaurant() {
    final var jpaRestaurant = createJpaRestaurant();
    final var saved = restaurantRepo.save(jpaRestaurant);
    return ResponseEntity.status(CREATED).body(toBo(saved));
  }

  @PostMapping("/seatings")
  public ResponseEntity<Seating> createSeating() {
    final var jpaSeating = createJpaSeating();
    final var saved = seatingRepo.save(jpaSeating);
    return ResponseEntity.status(CREATED).body(toBo(saved));
  }

  @GetMapping("/seatings")
  public ResponseEntity<List<Seating>> getSeatings() {
    final var jpaSeatingList = seatingRepo.findAll();
    final var seatingList = toBo(jpaSeatingList);
    return ResponseEntity.status(CREATED).body(seatingList);
  }

  @PostMapping("/clients")
  public ResponseEntity<Client> createClient() {
    final var jpaClient = createJpaClient();
    final var saved = clientRepo.save(jpaClient);
    return ResponseEntity.status(CREATED).body(toBo(saved));
  }

}
