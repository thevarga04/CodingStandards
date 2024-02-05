package acme.taurant.analytics;

import static org.assertj.core.api.Assertions.assertThat;

import acme.taurant.analytics.facepook.FacepookAnalytics;
import acme.taurant.analytics.gooble.GoobleAnalytics;
import acme.taurant.openapi.v2.model.SeatingBooking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnalyticsDispatcherServiceTest {

  @Mock
  FacepookAnalytics facepookAnalytics;

  @Mock
  GoobleAnalytics goobleAnalytics;

  @InjectMocks
  AnalyticsDispatcherService sut;


  @BeforeEach
  void setUp() {
    sut = new AnalyticsDispatcherService(facepookAnalytics, goobleAnalytics);
  }


  @Test
  void dispatch() {
    // Given
    var seatingBooking = new SeatingBooking();

    // When
    sut.dispatch(seatingBooking);

    // Then
    assertThat(seatingBooking).isNotNull();
  }
}