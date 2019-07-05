package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ResultDisplayer {
    protected ConsolePrinter consolePrinter;

    public void display(List<User> users) {
        String text = users.stream()
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "display users : ", ""));
        consolePrinter.print(text);
    }
}