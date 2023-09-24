package acme.realm;

import acme.client.JpaClient;
import acme.seating.JpaSeating;

public class RealmFactory {

  private RealmFactory() {
  }


  public static JpaRestaurant createJpaRestaurant() {
    return JpaRestaurant.builder()
      .build();
  }

  public static JpaSeating createJpaSeating() {
    return JpaSeating.builder()
      .capacity(4)
      .restaurant(JpaRestaurant.builder().id(1).build())
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
