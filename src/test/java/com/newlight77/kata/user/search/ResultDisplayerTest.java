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
        ResultDisplayer displayer = new ResultDisplayer(consolePrinter);

        // act
        displayer.display(users, ResultDisplayer.ORDER_TYPE.DEFAULT);

        // assert
        String expected = "display users : Kong To, Peter Ly, Mathieu Nguyen, Manuel Descartes";
        Assertions.assertNotNull(consolePrinter.getText());
        Assertions.assertEquals(consolePrinter.getText(), expected);
    }

    @Test
    public void display_users_order_by_lastname() {
        // arrange
        ConsolePrinterSpy consolePrinter = new ConsolePrinterSpy();
        ResultDisplayer displayer = new ResultDisplayer(consolePrinter);

        // act
        displayer.display(users, ResultDisplayer.ORDER_TYPE.BY_LASTNAME);

        // assert
        String expected = "display users : Manuel Descartes, Peter Ly, Mathieu Nguyen, Kong To";
        Assertions.assertNotNull(consolePrinter.getText());
        Assertions.assertEquals(consolePrinter.getText(), expected);
    }

    @Test
    public void display_users_order_by_age() {
        // arrange
        ConsolePrinterSpy consolePrinter = new ConsolePrinterSpy();
        ResultDisplayer displayer = new ResultDisplayer(consolePrinter);

        // act
        displayer.display(users, ResultDisplayer.ORDER_TYPE.BY_AGE);

        // assert
        String expected = "display users : Mathieu Nguyen, Peter Ly, Kong To, Manuel Descartes";
        Assertions.assertNotNull(consolePrinter.getText());
        Assertions.assertEquals(consolePrinter.getText(), expected);
    }
}
