package name.stepin.graphql.query;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import name.stepin.service.ExampleService;
import org.junit.jupiter.api.Test;

class ExampleQueryTests {

  @Test
  void checkGetExample() {
    ExampleService service = mock(ExampleService.class);
    when(service.dateString()).thenReturn("dateString");
    ExampleQuery query = new ExampleQuery(service);

    String example = query.getExample();

    assertThat(example).isEqualTo("dateString");
    verify(service).dateString();
  }

}
