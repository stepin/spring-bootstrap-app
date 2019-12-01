package name.stepin.health;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.Status;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RandomHealthChecker.class, Math.class})
public class RandomHealthCheckerTests {

  @Test
  public void healthIsUp() {
    PowerMockito.mockStatic(Math.class);
    PowerMockito.when(Math.random()).thenReturn(0.6);

    RandomHealthChecker checker = new RandomHealthChecker();
    Health.Builder builder = new Builder();

    checker.doHealthCheck(builder);

    Health health = builder.build();
    assertThat(health.getStatus()).isEqualTo(Status.UP);
  }

  @Test
  public void healthIsDown() {
    PowerMockito.mockStatic(Math.class);
    PowerMockito.when(Math.random()).thenReturn(0.1);

    RandomHealthChecker checker = new RandomHealthChecker();
    Health.Builder builder = new Builder();

    checker.doHealthCheck(builder);

    Health health = builder.build();
    assertThat(health.getStatus()).isEqualTo(Status.DOWN);
  }
}
