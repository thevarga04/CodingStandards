package acme.taurant.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TaurantCollections {

  private TaurantCollections() {
  }


  public static <T> Stream<T> ofNullable(Collection<T> collection) {
    return Optional.ofNullable(collection).stream().flatMap(Collection::stream);
  }

  public static <T> List<T> ofNullableArray(T[] array) {
    return Optional.ofNullable(array).stream().flatMap(Arrays::stream).toList();
  }


}
