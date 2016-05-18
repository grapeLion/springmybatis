package cn.ms.springbootmybatis.controller;

import cn.ms.springbootmybatis.domain.Person;
import cn.ms.springbootmybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emily on 16/5/18.
 */
@RestController
public class HelloController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/")
    public Person getPersonById(String id){
        return personMapper.findById(id);
    }
    @RequestMapping("/save")
    public void saveList(){
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setName("lisi");
        person.setAge(44);
        Person person1 = new Person();
        person1.setName("wangwu");
        person1.setAge(22);
        persons.add(person);
        persons.add(person1);
        personMapper.savePerson(persons);
    }
}
