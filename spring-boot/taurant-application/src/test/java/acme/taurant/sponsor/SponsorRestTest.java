package acme.taurant.sponsor;

import static acme.taurant.common.ObjectFactory.createRestaurant;
import static acme.taurant.common.ObjectFactory.createSeating;
import static acme.taurant.seating.booking.SeatingBookingMapper.toJpa;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

import acme.taurant.openapi.v2.model.Restaurant;
import acme.taurant.openapi.v2.model.Seating;
import org.hibernate.QueryParameterException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SponsorRestTest {

  @Mock
  RestaurantRepo restaurantRepo;

  @Mock
  SeatingRepo seatingRepo;

  @Mock
  ClientRepo clientRepo;

  @InjectMocks
  SponsorRest sut;

  static MockedStatic<SponsorFactory> realmFactory;


  @BeforeAll
  static void staticSetUp() {
    realmFactory = mockStatic(SponsorFactory.class);
  }

  @AfterAll
  static void staticCloseUp() {
    realmFactory.close();
  }


  @BeforeEach
  void setUp() {
    sut = new SponsorRest(restaurantRepo, seatingRepo, clientRepo);
  }


  @Test
  void createRestaurant_When_MockEverything_AntiPattern() {
    // Given
    var given = new JpaRestaurant();

    // When
    realmFactory.when(SponsorFactory::createJpaRestaurant).thenReturn(given);
    when(restaurantRepo.save(any())).thenReturn(given);
    var actual = sut.createRestaurant();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getStatusCode()).isEqualTo(CREATED);
    assertThat(actual.getBody()).isNotNull()
      .isExactlyInstanceOf(Restaurant.class);
  }

  @Test
  void createRestaurantTest() {
    // Given
    var given = new JpaRestaurant();

    // When
    when(restaurantRepo.save(any())).thenReturn(given);
    var actual = sut.createRestaurant();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getStatusCode()).isEqualTo(CREATED);
    assertThat(actual.getBody()).isNotNull()
      .isExactlyInstanceOf(Restaurant.class);
  }

  @Test
  void createRestaurant_When_RepoThrowsException() {
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
    var restaurant = createRestaurant();
    var given = toJpa(createSeating());
    given.setRestaurant(toJpa(restaurant));

    // When
    realmFactory.when(SponsorFactory::createJpaSeating).thenReturn(given);
    when(seatingRepo.save(any())).thenReturn(given);
    var actual = sut.createSeating();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getStatusCode()).isEqualTo(CREATED);
    assertThat(actual.getBody()).isNotNull()
      .isExactlyInstanceOf(Seating.class);
  }

}