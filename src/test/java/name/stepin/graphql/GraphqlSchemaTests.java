package name.stepin.graphql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
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
    // When
    GraphQLResponse response = graphQLTestTemplate.postForResource("/graphql/query-example.graphql");

    // Then
    assertThat(response).isNotNull();
    assertThat(response.isOk()).isTrue();
    assertThat(response.get("$.data.example")).isNotBlank();
  }

  @Test
  void createExample() throws Exception {
    // When
    GraphQLResponse response = graphQLTestTemplate.postForResource("/graphql/mutation-create-example.graphql");

    // Then
    assertThat(response).isNotNull();
    assertThat(response.isOk()).isTrue();
    assertThat(response.get("$.data.createExample")).isNotBlank();
  }

}
