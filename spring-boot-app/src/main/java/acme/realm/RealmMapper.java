package acme.realm;

import acme.client.JpaClient;
import acme.openapi.v2.model.Client;
import acme.openapi.v2.model.Restaurant;
import acme.openapi.v2.model.Seating;
import acme.seating.JpaSeating;

public class RealmMapper {

  private RealmMapper() {
  }


  public static Restaurant toBo(JpaRestaurant jpa) {
    return new Restaurant(jpa.getId());
  }

  public static Seating toBo(JpaSeating jpa) {
    final var seating = new Seating(jpa.getId(), toBo(jpa.getRestaurant()));
    seating.setCapacity(jpa.getCapacity());
    return seating;
  }

  public static Client toBo(JpaClient jpa) {
    final var client = new Client(jpa.getName());
    client.setId(jpa.getId());
    client.setEmail(jpa.getEmail());
    return client;
  }


}