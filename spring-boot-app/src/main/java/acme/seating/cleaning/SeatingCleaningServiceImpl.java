package acme.seating.cleaning;

import acme.openapi.v2.model.SeatingCleaning;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SeatingCleaningServiceImpl implements SeatingCleaningService {


  @Override
  public SeatingCleaning seatingCleaningInRestaurant(SeatingCleaning seatingCleaning) {
    return null;
  }

}