package acme.realm;

import acme.seating.JpaSeating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatingRepo extends JpaRepository<JpaSeating, Integer> {

}
