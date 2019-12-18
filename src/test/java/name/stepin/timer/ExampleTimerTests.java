package name.stepin.timer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import name.stepin.service.ExampleService;
import org.junit.jupiter.api.Test;

//example of unstable tests
class ExampleTimerTests {

  @Test
  void normalTick() {
    ExampleService exampleService = mock(ExampleService.class);
    ExampleTimer exampleTimer = new ExampleTimer(exampleService);

    long begin = System.currentTimeMillis();
    exampleTimer.tick();
    long duration = System.currentTimeMillis() - begin;

    verify(exampleService).dateString();
    assertThat(duration).isGreaterThan(100);
  }

  @Test
  void tickWithInterruptedException() {
    ExampleService exampleService = mock(ExampleService.class);
    ExampleTimer exampleTimer = new ExampleTimer(exampleService);

    Thread.currentThread().interrupt();
    long begin = System.currentTimeMillis();
    exampleTimer.tick();
    long duration = System.currentTimeMillis() - begin;

    verify(exampleService).dateString();
    assertThat(duration).isLessThan(1000);
  }
}
