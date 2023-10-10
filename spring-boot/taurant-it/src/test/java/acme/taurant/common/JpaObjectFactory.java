package acme.taurant.common;

import acme.taurant.seating.JpaSeating;
import acme.taurant.sponsor.JpaRestaurant;

public class JpaObjectFactory {

  private JpaObjectFactory() {
  }


  public static JpaSeating createJpaSeating() {
    return JpaSeating.builder()
      .id(1)
      .capacity(2)
      .restaurant(createJpaRestaurant())
      .build();
  }

  public static JpaRestaurant createJpaRestaurant() {
    return JpaRestaurant.builder()
      .id(1)
      .build();
  }


}
