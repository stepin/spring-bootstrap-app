package name.stepin.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class DbModel {

  private final String id;
  private final String name;
  private final String secret;

}
