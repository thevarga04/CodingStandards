package acme.taurant.realm;

import acme.taurant.client.JpaClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<JpaClient, Integer> {

}
