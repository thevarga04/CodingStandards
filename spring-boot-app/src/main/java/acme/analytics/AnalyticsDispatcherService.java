package acme.analytics;

import acme.analytics.facepook.FacepookAnalytics;
import acme.analytics.gooble.GoobleAnalytics;
import acme.openapi.v2.model.SeatingBooking;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsDispatcherService implements AnalyticsDispatcher {

  private final List<Analytics> analytics = new ArrayList<>();
  private final FacepookAnalytics facepookAnalytics;
  private final GoobleAnalytics goobleAnalytics;


  @PostConstruct
  public void init() {
    analytics.add(facepookAnalytics);
    analytics.add(goobleAnalytics);
  }


  @Override
  @Async
  public void dispatch(SeatingBooking seatingBooking) {
    analytics.forEach(a -> a.dispatch(seatingBooking));
  }

}
