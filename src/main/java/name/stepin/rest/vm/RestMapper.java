package name.stepin.rest.vm;

import name.stepin.domain.DbModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestMapper {

  RestMapper INSTANCE = Mappers.getMapper( RestMapper.class );

  @Mapping(source = "name", target = "title")
  RestModel dbToRest(DbModel dbModel);

}
