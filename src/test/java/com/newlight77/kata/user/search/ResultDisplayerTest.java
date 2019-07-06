package com.newlight77.kata.user.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResultDisplayerTest {

    List<User> users = Arrays.asList(
            User.builder().uid(2).firstname("Kong").lastname("To").age(37).email("kto@wesquad.io").build(),
            User.builder().uid(1).firstname("Peter").lastname("Ly").age(21).email("ply@wesquad.io").build(),
            User.builder().uid(5).firstname("Mathieu").lastname("Nguyen").age(18).email("mng@wesquad.io").build(),
            User.builder().uid(3).firstname("Manuel").lastname("Descartes").age(43).email("mde@wesquad.io").build()
    );

    @Test
    public void display_users() {
        // arrange
        ConsolePrinterSpy consolePrinter = new ConsolePrinterSpy();
        ResultDisplayer displayer = new ResultDisplayerConsole(consolePrinter);

        // act
        displayer.display(users);

        // assert
        String expected = "display users : Kong To, Peter Ly, Mathieu Nguyen, Manuel Descartes";
        Assertions.assertNotNull(consolePrinter.getText());
        Assertions.assertEquals(consolePrinter.getText(), expected);
    }
}
