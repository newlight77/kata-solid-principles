package com.newlight77.kata.user.search;

import java.util.List;
import java.util.stream.Collectors;

public interface ResultDisplayer {

    Printer getPrinter();

    default void display(List<User> users) {
        String text = users.stream()
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "display users : ", ""));
        getPrinter().print(text);
    }
}