package acme.taurant.realm;

import static acme.taurant.seating.booking.SeatingBookingMapper.toJpa;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import acme.taurant.common.SeatingFactory;
import acme.taurant.openapi.v2.model.Restaurant;
import acme.taurant.openapi.v2.model.Seating;
import org.hibernate.QueryParameterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class RealmRestTest {

  @Mock
  RestaurantRepo restaurantRepo;

  @Mock
  SeatingRepo seatingRepo;

  @Mock
  ClientRepo clientRepo;

  @InjectMocks
  RealmRest sut;

  static MockedStatic<RealmFactory> realmFactory;


  @BeforeAll
  static void staticSetUp() {
    realmFactory = mockStatic(RealmFactory.class);
  }


  @BeforeEach
  void setUp() {
    sut = new RealmRest(restaurantRepo, seatingRepo, clientRepo);
  }


  @Test
  void createRestaurant_When_MockEverything_AntiPattern() {
    // Given
    var given = new JpaRestaurant();

    // When
    realmFactory.when(RealmFactory::createJpaRestaurant).thenReturn(given);
    when(restaurantRepo.save(any())).thenReturn(given);
    var actual = sut.createRestaurant();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(actual.getBody()).isNotNull()
      .isExactlyInstanceOf(Restaurant.class);
  }

  @Test
  void createRestaurant() {
    // Given
    var given = new JpaRestaurant();

    // When
    when(restaurantRepo.save(any())).thenReturn(given);
    var actual = sut.createRestaurant();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(actual.getBody()).isNotNull()
      .isExactlyInstanceOf(Restaurant.class);
  }

  @Test
  void createRestaurant_When_RuntimeException() {
    // When
    when(restaurantRepo.save(any())).thenThrow(new QueryParameterException("Lorem Ipsum"));

    // Then
    assertThatThrownBy(
      () -> sut.createRestaurant()
    ).isInstanceOf(QueryParameterException.class);
  }


  @Test
  void createSeating_When_MockEverything_And_Using_ProductionCode_AntiPatterns() {
    // Given
    var given = toJpa(SeatingFactory.createSeating());

    // When
    realmFactory.when(RealmFactory::createJpaSeating).thenReturn(given);
    when(seatingRepo.save(any())).thenReturn(given);
    var actual = sut.createSeating();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(actual.getBody()).isNotNull()
      .isExactlyInstanceOf(Seating.class);
  }

}