package acme.realm;

import static acme.realm.RealmFactory.createJpaClient;
import static acme.realm.RealmFactory.createJpaRestaurant;
import static acme.realm.RealmFactory.createJpaSeating;
import static acme.realm.RealmMapper.toBo;

import acme.openapi.v2.model.Client;
import acme.openapi.v2.model.Restaurant;
import acme.openapi.v2.model.Seating;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/realm")
@RequiredArgsConstructor
@Profile(value = "Sponsor")
public class RealmRest {

  private final RestaurantRepo restaurantRepo;
  private final SeatingRepo seatingRepo;
  private final ClientRepo clientRepo;


  @PostMapping("/restaurants")
  public ResponseEntity<Restaurant> createRestaurant() {
    final var jpaRestaurant = createJpaRestaurant();
    final var jpa = restaurantRepo.save(jpaRestaurant);
    return ResponseEntity.ok(toBo(jpa));
  }

  @PostMapping("/seatings")
  public ResponseEntity<Seating> createSeating() {
    final var jpaSeating = createJpaSeating();
    final var jpa = seatingRepo.save(jpaSeating);
    return ResponseEntity.ok(toBo(jpa));
  }

  @PostMapping("/clients")
  public ResponseEntity<Client> createClient() {
    final var jpaClient = createJpaClient();
    final var jpa = clientRepo.save(jpaClient);
    return ResponseEntity.ok(toBo(jpa));
  }

}
