package acme.common;

import acme.openapi.v2.model.Client;
import acme.openapi.v2.model.Restaurant;
import acme.openapi.v2.model.Seating;
import acme.openapi.v2.model.SeatingBooking;

public class SeatingFactory {

  private SeatingFactory() {
  }


  public static SeatingBooking createSeatingBooking() {
    return new SeatingBooking(
      2
      , 2000000000L
      , 3000000000L
      , createClient()
      , createSeating()
    );
  }

  public static Client createClient() {
    final var client = new Client("JohnDoe");
    client.setId(1);
    client.setEmail("john.doe@acme.com");
    return client;
  }

  public static Seating createSeating() {
    final var seating = new Seating(1, createRestaurant());
    seating.setCapacity(4);
    return seating;
  }

  public static Restaurant createRestaurant() {
    return new Restaurant(1);
  }

}

