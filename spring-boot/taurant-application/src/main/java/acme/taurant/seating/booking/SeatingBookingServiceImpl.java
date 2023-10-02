package acme.taurant.seating.booking;

import static acme.taurant.seating.booking.SeatingBookingMapper.toJpa;
import static org.springframework.beans.BeanUtils.copyProperties;

import acme.taurant.analytics.AnalyticsDispatcher;
import acme.taurant.openapi.v2.model.SeatingBooking;
import acme.taurant.seating.booking.jpa.JpaSeatingBooking;
import acme.taurant.seating.booking.jpa.SeatingBookingDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatingBookingServiceImpl implements SeatingBookingService {

  private final SeatingBookingDao<JpaSeatingBooking> seatingBookingDao;
  private final AnalyticsDispatcher analyticsDispatcher;


  @Override
  public SeatingBooking seatingBookingInRestaurant(SeatingBooking seatingBooking) {
    seatingBookingDao.assertNotOverlap(seatingBooking);
    final var jpaSeatingBooking = toJpa(seatingBooking);
    final var saved = seatingBookingDao.save(jpaSeatingBooking);
    analyticsDispatcher.dispatch(seatingBooking);
    copyProperties(saved, seatingBooking);
    return seatingBooking;
  }

}
