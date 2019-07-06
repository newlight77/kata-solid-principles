package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class ResultDisplayerOrderByFirstname implements ResultDisplayer {

    @Getter
    private ConsolePrinter consolePrinter;

    @Override
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(User::getFirstname));
    }
}
