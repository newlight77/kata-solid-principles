package com.newlight77.kata.user.search;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultDisplayerOrderByLastname extends ResultDisplayer {
    public ResultDisplayerOrderByLastname(ConsolePrinter consolePrinter) {
        super(consolePrinter);
    }

    @Override
    protected void sort(List<User> users) {
        users.sort(Comparator.comparing(User::getLastname));
    }
}
