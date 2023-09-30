package acme.taurant.seating.booking.jpa;

import acme.taurant.client.JpaClient;
import acme.taurant.seating.JpaSeating;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seating_bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JpaSeatingBooking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Min(1)
  private int quantity;

  @Min(10_000_000_000L)
  @Max(9_000_000_000_000L)
  private long since;

  @Min(10_000_000_000L)
  @Max(9_000_000_000_000L)
  private long until;

  @ManyToOne
  @JoinColumn(name = "client_id", updatable = false, nullable = false)
  private JpaClient client;

  @ManyToOne
  @JoinColumn(name = "seating_id", updatable = false, nullable = false)
  private JpaSeating seating;

}
