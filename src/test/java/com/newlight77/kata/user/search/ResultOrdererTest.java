package com.newlight77.kata.user.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResultOrdererTest {

    List<User> users = Arrays.asList(
            User.builder().uid(2).firstname("Kong").lastname("To").age(37).email("kto@wesquad.io").build(),
            User.builder().uid(1).firstname("Peter").lastname("Ly").age(21).email("ply@wesquad.io").build(),
            User.builder().uid(5).firstname("Mathieu").lastname("Nguyen").age(18).email("mng@wesquad.io").build(),
            User.builder().uid(3).firstname("Manuel").lastname("Descartes").age(43).email("mde@wesquad.io").build()
    );

    @Test
    public void order_by_lastname() {
        // arrange
        ResultOrderer resultOrderer = new ResultOrderByLastname();

        // act
        resultOrderer.sort(users);

        // assert
        Assertions.assertNotNull(users);
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals("Descartes", users.get(0).getLastname());
        Assertions.assertEquals("Ly", users.get(1).getLastname());
        Assertions.assertEquals("Nguyen", users.get(2).getLastname());
        Assertions.assertEquals("To", users.get(3).getLastname());
    }

    @Test
    public void order_by_firstname() {
        // arrange
        ResultOrderer resultOrderer = new ResultOrderByFirstname();

        // act
        resultOrderer.sort(users);

        // assert
        Assertions.assertNotNull(users);
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals("Kong", users.get(0).getFirstname());
        Assertions.assertEquals("Manuel", users.get(1).getFirstname());
        Assertions.assertEquals("Mathieu", users.get(2).getFirstname());
        Assertions.assertEquals("Peter", users.get(3).getFirstname());
    }

    @Test
    public void order_by_age() {
        // arrange
        ResultOrderer resultOrderer = new ResultOrderByAge();

        // act
        resultOrderer.sort(users);

        // assert
        Assertions.assertNotNull(users);
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals(18, users.get(0).getAge());
        Assertions.assertEquals(21, users.get(1).getAge());
        Assertions.assertEquals(37, users.get(2).getAge());
        Assertions.assertEquals(43, users.get(3).getAge());
    }

    @Test
    public void order_by_email() {
        // arrange
        ResultOrderer resultOrderer = new ResultOrderByEmail();

        // act
        resultOrderer.sort(users);

        // assert
        Assertions.assertNotNull(users);
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals("kto@wesquad.io", users.get(0).getEmail());
        Assertions.assertEquals("mde@wesquad.io", users.get(1).getEmail());
        Assertions.assertEquals("mng@wesquad.io", users.get(2).getEmail());
        Assertions.assertEquals("ply@wesquad.io", users.get(3).getEmail());
    }
}
