package name.stepin.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import name.stepin.service.ExampleService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ExampleMutation implements GraphQLMutationResolver {

  private final ExampleService service;

  public String createExample(final String exampleDate) {
    return service.create(exampleDate);
  }

}
