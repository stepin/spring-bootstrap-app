package name.stepin.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthChecker extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Builder builder) {
        boolean isUp = Math.random() > 0.5;
        if (isUp) {
            builder.up().withDetail("Random Status", "working");
        } else {
            builder.down().withDetail("Random Status", "it's random");
        }
    }

}
