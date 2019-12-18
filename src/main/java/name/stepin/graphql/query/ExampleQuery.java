package name.stepin.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import name.stepin.service.ExampleService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ExampleQuery implements GraphQLQueryResolver {

  private final ExampleService service;

  public String getExample() {
    return service.dateString();
  }

}
