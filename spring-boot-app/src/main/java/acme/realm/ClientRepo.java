package acme.realm;

import acme.client.JpaClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<JpaClient, Integer> {

}
