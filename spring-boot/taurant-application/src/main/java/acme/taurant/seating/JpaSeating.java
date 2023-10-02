package acme.taurant.seating;

import acme.taurant.sponsor.JpaRestaurant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seatings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JpaSeating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Min(1)
  private int capacity;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", updatable = false, nullable = false)
  private JpaRestaurant restaurant;

}
