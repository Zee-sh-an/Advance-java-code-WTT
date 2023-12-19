package com.testing.service;

import com.testing.entites.Person;
import com.testing.respostory.PersonRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepo personRepo;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        this.personService=new PersonService(this.personRepo);
    }

    @Test
    void getAllPerson() {

        personService.getAllPerson();
        verify(personRepo).findAll();

    }

    @Test
    void isPersonExitsById() {
        Person person=new Person(122,"Zeeshan","Agra");
        personRepo.save(person);

        Boolean actualResult = personRepo.isPersonExitsById(122);
//        assertThat(actualResult).isTrue();
        verify(personRepo).save(person);

    }


}