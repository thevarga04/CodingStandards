package acme.seating.booking;

import static acme.seating.booking.SeatingBookingMapper.toJpa;
import static org.springframework.beans.BeanUtils.copyProperties;

import acme.analytics.AnalyticsDispatcher;
import acme.openapi.v2.model.SeatingBooking;
import acme.seating.booking.jpa.JpaSeatingBooking;
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
    seatingBookingDao.assertNotPreoccupied(seatingBooking);
    final var jpaSeatingBooking = toJpa(seatingBooking);
    final var saved = seatingBookingDao.save(jpaSeatingBooking);
    analyticsDispatcher.dispatch(seatingBooking);
    copyProperties(saved, seatingBooking);
    return seatingBooking;
  }

}
