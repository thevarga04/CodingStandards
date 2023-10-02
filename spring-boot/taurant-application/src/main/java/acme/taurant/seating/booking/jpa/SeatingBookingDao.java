package acme.taurant.seating.booking.jpa;

import static org.springframework.util.CollectionUtils.isEmpty;

import acme.taurant.openapi.v2.model.SeatingBooking;
import acme.taurant.seating.booking.exception.SeatingBookingOverlappingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatingBookingDao<T extends JpaSeatingBooking> {

  private final SeatingBookingRepo seatingBookingRepo;


  public void assertNotOverlap(SeatingBooking seatingBooking) {
    final var jpaSeatingBookingList = seatingBookingRepo.getOverlaps(
      seatingBooking.getSince()
      , seatingBooking.getUntil()
      , seatingBooking.getSeating().getId()
    );

    if (!isEmpty(jpaSeatingBookingList)) {
      throw new SeatingBookingOverlappingException();
    }
  }


  public T save(T jpa) {
    return seatingBookingRepo.save(jpa);
  }

}
