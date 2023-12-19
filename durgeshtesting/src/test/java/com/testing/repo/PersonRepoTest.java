package com.testing.repo;

import com.testing.entites.Person;
import com.testing.respostory.PersonRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;


    @Test
    void isPersonExitsById() {
        Person person=new Person(122,"Zeeshan","Agra");
        personRepo.save(person);

        Boolean actualResult = personRepo.isPersonExitsById(122);
        assertThat(actualResult).isTrue();

    }

    @AfterEach
    void tearDown() {//it runs after the test method

        System.out.println("Tearing down");
//        personRepo.deleteAll();
    }

    @BeforeEach
    void setUp() {//it runs before the test method

        System.out.println("setting up");

    }
}