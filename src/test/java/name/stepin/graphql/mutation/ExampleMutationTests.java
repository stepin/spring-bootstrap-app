package name.stepin.graphql.mutation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import name.stepin.service.ExampleService;
import org.junit.jupiter.api.Test;

class ExampleMutationTests {

  @Test
  void checkCreateExample() {
    ExampleService service = mock(ExampleService.class);
    when(service.create(anyString())).thenReturn("dateString");
    ExampleMutation mutation = new ExampleMutation(service);

    String example = mutation.createExample("dateString");

    assertThat(example).isEqualTo("dateString");
    verify(service).create("dateString");
  }

}
