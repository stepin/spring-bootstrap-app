package name.stepin.graphql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("name.stepin")
@GraphQLTest
class GraphqlSchemaTests {

  @Autowired
  private GraphQLTestTemplate graphQLTestTemplate;

  @Test
  void getExample() throws Exception {
    GraphQLResponse response = successfulGraphQLPost("query-example.graphql");

    assertThat(response.get("$.data.example")).isNotBlank();
  }

  @Test
  void createExample() throws Exception {
    GraphQLResponse response = successfulGraphQLPost("mutation-create-example.graphql");

    assertThat(response.get("$.data.createExample")).isNotBlank();
  }

  private GraphQLResponse successfulGraphQLPost(String resourceName) throws IOException {
    GraphQLResponse response = graphQLTestTemplate.postForResource("/graphql/" + resourceName);

    assertThat(response).isNotNull();
    assertThat(response.isOk()).isTrue();

    return response;
  }

}
