package acme.taurant.sponsor;

import acme.taurant.client.JpaClient;
import acme.taurant.seating.JpaSeating;
import java.util.concurrent.atomic.AtomicInteger;

public class RealmFactory {

  private static final AtomicInteger COUNTER = new AtomicInteger(1);


  private RealmFactory() {
  }


  public static JpaRestaurant createJpaRestaurant() {
    return JpaRestaurant.builder()
      .name("My Restaurant No: " + COUNTER.getAndIncrement())
      .build();
  }

  public static JpaSeating createJpaSeating() {
    return JpaSeating.builder()
      .capacity(4)
      .restaurant(JpaRestaurant.builder().id(2).build())
      .build();
  }

  public static JpaClient createJpaClient() {
    return JpaClient.builder()
      .id(1)
      .name("JohnDoe")
      .email("john.doe@acme.com")
      .build();
  }

}
