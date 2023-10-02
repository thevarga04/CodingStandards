package acme.taurant.seating.booking.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatingBookingRepo extends JpaRepository<JpaSeatingBooking, Integer> {

  /**
   * In case of (semantically) complex queries it could be a better option to use JPQL query,
   * especially when a condition seems to be counter-intuitive and provide the explanation why.
   * <p>
   * Get list of bookings which overlaps with the given parameters.
   */
  @Query("select b from JpaSeatingBooking b where"
    + " b.since < :until"
    + " and b.until > :since"
    + " and b.seating.id = :seatingId"
  )
  List<JpaSeatingBooking> getOverlaps(long since, long until, int seatingId);

  List<JpaSeatingBooking> getBySinceBeforeAndUntilAfterAndSeating_Id(long until, long since, int seatingId);

}
