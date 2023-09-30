package acme.taurant.seating.booking;

import static acme.taurant.seating.booking.SeatingBookingValidator.assertEmpty;

import acme.taurant.openapi.v2.model.SeatingBooking;
import acme.taurant.seating.booking.jpa.JpaSeatingBooking;
import acme.taurant.seating.booking.jpa.SeatingBookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatingBookingDao<T extends JpaSeatingBooking> {

  private final SeatingBookingRepo seatingBookingRepo;


  public void assertNotPreoccupied(SeatingBooking seatingBooking) {
    final var jpaSeatingBookingList = seatingBookingRepo.findBySinceAfterAndUntilBeforeAndSeating_Id(
      seatingBooking.getSince()
      , seatingBooking.getUntil()
      , seatingBooking.getSeating().getId()
    );
    assertEmpty(jpaSeatingBookingList);
  }


  public T save(T jpa) {
    return seatingBookingRepo.save(jpa);
  }

}
