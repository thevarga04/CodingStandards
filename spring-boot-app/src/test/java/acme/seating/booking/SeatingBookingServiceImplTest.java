package acme.seating.booking;

import static acme.common.SeatingFactory.createSeatingBooking;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import acme.analytics.AnalyticsDispatcherService;
import acme.seating.booking.jpa.JpaSeatingBooking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SeatingBookingServiceImplTest {

  @Mock
  SeatingBookingDao<JpaSeatingBooking> seatingBookingDao;

  @Mock
  AnalyticsDispatcherService analyticsDispatcher;

  @InjectMocks
  SeatingBookingServiceImpl sut;


  @BeforeEach
  void setUp() {
    sut = new SeatingBookingServiceImpl(seatingBookingDao, analyticsDispatcher);
  }


  @Test
  void seatingBookingInRestaurant() {
    // Given
    var given = createSeatingBooking();

    // When
    when(seatingBookingDao.save(any())).thenReturn(new JpaSeatingBooking());
    var actual = sut.seatingBookingInRestaurant(given);

    // Then
    assertThat(actual).isNotNull()
      .hasNoNullFieldsOrProperties();
  }

}