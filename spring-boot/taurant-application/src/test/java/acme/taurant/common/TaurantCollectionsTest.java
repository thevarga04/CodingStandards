package acme.taurant.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class TaurantCollectionsTest {


  @ParameterizedTest
  @MethodSource("generateList")
  void ofNullableTest(Collection<String> collection) {
    // When
    var actual = TaurantCollections.ofNullable(collection);

    // Then
    assertThat(actual).isNotNull();
  }

  static Stream<List<String>> generateList() {
    return Stream.of(null, List.of(), List.of(""), Collections.emptyList(), List.of("s1", "s2"));
  }


  @ParameterizedTest
  @NullAndEmptySource
  void ofNullableArrayTest(String[] array) {
    // When
    var actual = TaurantCollections.ofNullableArray(array);

    // Then
    assertThat(actual).isNotNull();
  }

}