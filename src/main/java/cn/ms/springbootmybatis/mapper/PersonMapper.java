package cn.ms.springbootmybatis.mapper;

import cn.ms.springbootmybatis.domain.Person;
import cn.ms.springbootmybatis.mapper.provider.PersonMapperProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Emily on 16/5/18.
 */
@Mapper
public interface PersonMapper {
    @Select("select * from person where id = #{id}")
    Person findById(@Param("id") String personId);


    @InsertProvider(type = PersonMapperProvider.class,method = "insertAll")
    void savePerson(List<Person> persons);
}
