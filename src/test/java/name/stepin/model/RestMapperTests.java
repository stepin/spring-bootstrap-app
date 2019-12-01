package name.stepin.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RestMapperTests {

  @Test
  void shouldMapCarToDto() {
    //given
    DbModel dbModel = new DbModel( "id1", "name1", "secret1" );

    //when
    RestModel restModel = RestMapper.INSTANCE.dbToRest( dbModel );

    //then
    assertThat( restModel ).isNotNull();
    assertThat( restModel.getId() ).isEqualTo( "id1" );
    assertThat( restModel.getTitle() ).isEqualTo( "name1" );
  }

}
