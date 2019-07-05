package com.newlight77.kata.user.search;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultDisplayerOrderByFirstname extends ResultDisplayer {
    public ResultDisplayerOrderByFirstname(ConsolePrinter consolePrinter) {
        super(consolePrinter);
    }

    @Override
    public void display(List<User> users) {
        String text = users.stream()
                .sorted(Comparator.comparing(User::getFirstname))
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "display users : ", ""));
        consolePrinter.print(text);
    }
}
