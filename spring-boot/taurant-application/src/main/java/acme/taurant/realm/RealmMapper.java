package acme.taurant.realm;

import acme.taurant.client.JpaClient;
import acme.taurant.openapi.v2.model.Client;
import acme.taurant.openapi.v2.model.Restaurant;
import acme.taurant.openapi.v2.model.Seating;
import acme.taurant.seating.JpaSeating;
import java.util.ArrayList;
import java.util.List;

public class RealmMapper {

  private RealmMapper() {
  }


  public static Restaurant toBo(JpaRestaurant jpa) {
    return new Restaurant(jpa.getId());
  }

  public static List<Seating> toBo(List<JpaSeating> jpaList) {
    final var seatingList = new ArrayList<Seating>();
    for (final var jpa : jpaList) {
      final var seating = new Seating(jpa.getId(), toBo(jpa.getRestaurant()));
      seating.setCapacity(jpa.getCapacity());
      seatingList.add(seating);
    }
    return seatingList;
  }

  public static Seating toBo(JpaSeating jpa) {
    final var seating = new Seating(jpa.getId(), toBo(jpa.getRestaurant()));
    seating.setCapacity(jpa.getCapacity());
    return seating;
  }

  public static Client toBo(JpaClient jpa) {
    final var client = new Client(jpa.getId());
    client.setName(jpa.getName());
    client.setEmail(jpa.getEmail());
    return client;
  }


}