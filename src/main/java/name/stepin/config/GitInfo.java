package name.stepin.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class GitInfo {

  private final String branch;

  //NOTE: throw exception in constructor to validate properties
  public GitInfo(@Value("${git.branch}") String branch) {
    this.branch = branch;
  }

}
