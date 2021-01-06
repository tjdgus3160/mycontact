package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("john");
        person.setAge(10);
        person.setBloodType("A");

        personRepository.save(person);

        List<Person> result = personRepository.findByName("martin");

        assertEquals(result.size(),1);
        assertEquals(result.get(0).getName(),"martin");
        assertEquals(result.get(0).getAge(),10);
        assertEquals(result.get(0).getBloodType(),"A");
    }

    @Test
    void constructorTest(){
        Person person = new Person("martin",10,"A");
    }

    @Test
    void hashCodeAndEquals(){
        Person person1 = new Person("martin",10,"A");
        Person person2 = new Person("martin",10,"A");

        System.out.println(person1.equals(person2));

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1,person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));
    }

    @Test
    void findByBloodType(){
        List<Person> result = personRepository.findByBloodType("A");

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getName(),"martin");
        assertEquals(result.get(1).getName(),"benny");
    }

    @Test
    void findByBirthdayBetween(){
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getName(),"martin");
        assertEquals(result.get(1).getName(),"sophia");

    }

    private void givenPerson(String name, int age, String bloodType){
        givenPerson(name,age,bloodType,null);
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday){
        Person person = new Person(name,age,bloodType);
        person.setBirthday(new Birthday(birthday));
        personRepository.save(person);
    }
}