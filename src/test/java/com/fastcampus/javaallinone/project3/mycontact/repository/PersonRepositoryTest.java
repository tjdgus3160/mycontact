package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void findByName(){
        List<Person> people = personRepository.findByName("tony");

        assertEquals(people.size(),1);

        Person person = people.get(0);
        assertAll(
                ()->assertEquals(person.getName(),"tony"),
                ()->assertEquals(person.getHobby(),"reading"),
                ()->assertEquals(person.getAddress(),"seoul"),
                ()->assertEquals(person.getBirthday(), Birthday.of(LocalDate.of(1991,7,10))),
                ()->assertEquals(person.getJob(),"officer"),
                ()->assertEquals(person.getPhoneNumber(),"010-2222-5555"),
                ()->assertEquals(person.isDeleted(),false)
        );
    }

    @Test
    void findByNamdIfDeleted(){
        List<Person> people = personRepository.findByName("andrew");

        assertEquals(people.size(),0);
    }

    @Test
    void findByMonthOfBirthday(){
        List<Person> people = personRepository.findByMonthOfBirthday(7);

        assertEquals(people.size(),2);
        assertAll(
                ()->assertEquals(people.get(0).getName(),"david"),
                ()->assertEquals(people.get(1).getName(),"tony")
        );
    }

    @Test
    void findPeopleDeleted(){
        List<Person> people = personRepository.findPeopleDeleted();

        assertEquals(people.size(),1);
        assertEquals(people.get(0).getName(),"andrew");
    }

}