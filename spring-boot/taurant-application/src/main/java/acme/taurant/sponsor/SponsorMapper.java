package acme.taurant.sponsor;

import static acme.taurant.common.Collections.ofNullable;

import acme.taurant.client.JpaClient;
import acme.taurant.openapi.v2.model.Client;
import acme.taurant.openapi.v2.model.Restaurant;
import acme.taurant.openapi.v2.model.Seating;
import acme.taurant.seating.JpaSeating;
import java.util.List;

public class SponsorMapper {

  private SponsorMapper() {
  }


  public static Restaurant toBo(JpaRestaurant jpa) {
    return new Restaurant(jpa.getId());
  }

  public static List<Seating> toBo(List<JpaSeating> jpaList) {
    return ofNullable(jpaList)
      .map(jpa -> new Seating(jpa.getId(), toBo(jpa.getRestaurant())).capacity(jpa.getCapacity()))
      .toList();
  }

  public static Seating toBo(JpaSeating jpa) {
    return new Seating(jpa.getId(), toBo(jpa.getRestaurant()))
      .capacity(jpa.getCapacity());
  }

  public static Client toBo(JpaClient jpa) {
    return new Client(jpa.getId())
      .name(jpa.getName())
      .email(jpa.getEmail());
  }


}