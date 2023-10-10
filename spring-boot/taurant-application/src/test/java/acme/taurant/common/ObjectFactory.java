package acme.taurant.common;

import acme.taurant.openapi.v2.model.Client;
import acme.taurant.openapi.v2.model.Restaurant;
import acme.taurant.openapi.v2.model.Seating;
import acme.taurant.openapi.v2.model.SeatingBooking;

public class ObjectFactory {

  private ObjectFactory() {
  }


  public static SeatingBooking createSeatingBooking() {
    return new SeatingBooking(
      0
      , 2
      , 90000000000L
      , 90000720000L
      , createClient()
      , createSeating()
    );
  }

  public static Client createClient() {
    final var client = new Client(1);
    client.setName("JohnDoe");
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

