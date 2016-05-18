package cn.ms.springbootmybatis.mapper.provider;

import cn.ms.springbootmybatis.domain.Person;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Emily on 16/5/18.
 */
public class PersonMapperProvider {
    public  String insertAll(Map<String, List<Person>> map){
        List<Person> list = map.get("list");
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("insert into person (name, age) values ");
        MessageFormat messageFormat = new MessageFormat("(#'{'list[{0}].name},#'{'list[{0}].age})");
        System.out.println(messageFormat);
        for (int i = 0; i < list.size(); i++) {
            String format = messageFormat.format(new Integer[]{i});
            System.out.println(format);
            stringBuilder.append(messageFormat.format(new Integer[]{i}));
            stringBuilder.append(",");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
