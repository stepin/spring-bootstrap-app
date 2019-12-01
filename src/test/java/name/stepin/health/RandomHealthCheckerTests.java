package name.stepin.health;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.Status;

class RandomHealthCheckerTests {

  @Test
  void healthIsUp() {
    RandomHealthChecker checker = spy(new RandomHealthChecker());
    when(checker.getRandomValue()).thenReturn(0.6);
    Health.Builder builder = new Builder();

    checker.doHealthCheck(builder);

    Health health = builder.build();
    assertThat(health.getStatus()).isEqualTo(Status.UP);
  }

  @Test
  void healthIsDown() {
    RandomHealthChecker checker = spy(new RandomHealthChecker());
    when(checker.getRandomValue()).thenReturn(0.1);
    Health.Builder builder = new Builder();

    checker.doHealthCheck(builder);

    Health health = builder.build();
    assertThat(health.getStatus()).isEqualTo(Status.DOWN);
  }
}
