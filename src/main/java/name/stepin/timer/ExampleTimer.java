package name.stepin.timer;

import io.micrometer.core.instrument.Metrics;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.stepin.service.ExampleService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExampleTimer {

  private final ExampleService exampleService;
  private final Random random = new Random();

  @Scheduled(initialDelayString = "${application.exampleTimerInitialDelayMs}",
      fixedDelayString = "${application.exampleTimerFixedDelayMs}")
  public void tick() {
    log.info("Started");
    long start = System.currentTimeMillis();

    randomSleep();
    log.info("data from service: {}", exampleService.dateString());

    long stop = System.currentTimeMillis();
    Metrics.gauge("services.system.exampleTimer.cycle.timing", (double) stop - start);
  }

  private void randomSleep() {
    try {
      Thread.sleep(random.nextInt(1000));
    } catch (InterruptedException e) {
      log.warn("error in sleep", e);
      Thread.currentThread().interrupt();
    }
  }

}
