package name.stepin.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class GitInfo {

  @Value("${git.branch}")
  private final String branch;

  //NOTE: throw exception in constructor to validate properties

}
