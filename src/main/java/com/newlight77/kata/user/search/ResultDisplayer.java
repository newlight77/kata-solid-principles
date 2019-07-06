package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public interface ResultDisplayer {

    ConsolePrinter getConsolePrinter();

    void sort(List<User> users);

    default void display(List<User> users) {
        sort(users);
        String text = users.stream()
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "display users : ", ""));
        getConsolePrinter().print(text);
    }
}