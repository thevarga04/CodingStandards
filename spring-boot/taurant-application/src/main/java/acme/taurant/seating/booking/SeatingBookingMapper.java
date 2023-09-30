package acme.taurant.seating.booking;

import acme.taurant.client.JpaClient;
import acme.taurant.openapi.v2.model.Client;
import acme.taurant.openapi.v2.model.Restaurant;
import acme.taurant.openapi.v2.model.Seating;
import acme.taurant.openapi.v2.model.SeatingBooking;
import acme.taurant.realm.JpaRestaurant;
import acme.taurant.seating.JpaSeating;
import acme.taurant.seating.booking.jpa.JpaSeatingBooking;

public class SeatingBookingMapper {

  private SeatingBookingMapper() {
  }


  public static JpaSeatingBooking toJpa(SeatingBooking seatingBooking) {
    return JpaSeatingBooking.builder()
      .quantity(seatingBooking.getQuantity())
      .since(seatingBooking.getSince())
      .until(seatingBooking.getUntil())
      .client(toJpa(seatingBooking.getClient()))
      .seating(toJpa(seatingBooking.getSeating()))
      .build();
  }

  public static JpaClient toJpa(Client client) {
    return JpaClient.builder()
      .id(client.getId())
      .build();
  }

  public static JpaSeating toJpa(Seating seating) {
    return JpaSeating.builder()
      .id(seating.getId())
      .build();
  }

  public static JpaRestaurant toJpa(Restaurant restaurant) {
    return JpaRestaurant.builder()
      .id(restaurant.getId())
      .build();
  }


}
