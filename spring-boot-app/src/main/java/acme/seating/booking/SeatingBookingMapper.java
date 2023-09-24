package acme.seating.booking;

import acme.client.JpaClient;
import acme.openapi.v2.model.Client;
import acme.openapi.v2.model.Restaurant;
import acme.openapi.v2.model.Seating;
import acme.openapi.v2.model.SeatingBooking;
import acme.realm.JpaRestaurant;
import acme.seating.JpaSeating;
import acme.seating.booking.jpa.JpaSeatingBooking;

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
      .name(client.getName())
      .email(client.getEmail())
      .build();
  }

  public static JpaSeating toJpa(Seating seating) {
    return JpaSeating.builder()
      .id(seating.getId())
      .capacity(seating.getCapacity())
      .restaurant(toJpa(seating.getRestaurant()))
      .build();
  }

  public static JpaRestaurant toJpa(Restaurant restaurant) {
    return JpaRestaurant.builder()
      .id(restaurant.getId())
      .build();
  }


}
