package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void getPeopleExcludeBlocks(){
        List<Person> result = personService.getPeopleExcludeBlocks();

        result.forEach(System.out::println);

        assertEquals(result.size(),3);
        assertEquals(result.get(0).getName(),"martin");
        assertEquals(result.get(1).getName(),"david");
        assertEquals(result.get(2).getName(),"benny");
    }

    @Test
    void getPeopleByName(){
        List<Person> result = personService.getPeopleByName("martin");

        assertEquals(result.size(),1);
        assertEquals(result.get(0).getName(),"martin");
    }

    @Test
    void getPerson(){
        Person person = personService.getPerson(3L);

        assertEquals(person.getName(),"dennis");
    }
}