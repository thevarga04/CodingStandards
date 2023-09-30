package acme.taurant.seating.booking.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatingBookingRepo extends JpaRepository<JpaSeatingBooking, Integer> {


  List<JpaSeatingBooking> findBySinceAfterAndUntilBeforeAndSeating_Id(long since, long until, int seatingId);

}
