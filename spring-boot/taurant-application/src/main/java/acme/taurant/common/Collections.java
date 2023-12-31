package acme.taurant.common;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class Collections {

  private Collections() {
  }


  public static <T> Stream<T> ofNullable(Collection<T> collection) {
    return Optional.ofNullable(collection).stream().flatMap(Collection::stream);
  }


}
