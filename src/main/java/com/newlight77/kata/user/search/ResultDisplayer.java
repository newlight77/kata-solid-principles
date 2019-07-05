package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ResultDisplayer {

    private ConsolePrinter consolePrinter;

    enum ORDER_TYPE {
        BY_LASTNAME,
        BY_FIRSTNAME,
        BY_AGE,
        DEFAULT;
    }

    public void display(List<User> users, ORDER_TYPE orderType) {
        String text = "";
        switch (orderType) {
            case BY_LASTNAME:
                text = users.stream()
                        .sorted(Comparator.comparing(User::getLastname))
                        .map(u -> u.getFirstname() + " " + u.getLastname())
                        .collect(Collectors.joining(", ",
                                "display users : ", ""));
                break;
            case BY_FIRSTNAME:
                text = users.stream()
                        .sorted(Comparator.comparing(User::getFirstname))
                        .map(u -> u.getFirstname() + " " + u.getLastname())
                        .collect(Collectors.joining(", ",
                                "displaying users ordered by firstname :", ""));
                break;
            case BY_AGE:
                text = users.stream()
                        .sorted(Comparator.comparing(User::getAge))
                        .map(u -> u.getFirstname() + " " + u.getLastname())
                        .collect(Collectors.joining(", ",
                                "display users : ", ""));
                break;
            case DEFAULT:
            default:
                text = users.stream()
                        .map(u -> u.getFirstname() + " " + u.getLastname())
                        .collect(Collectors.joining(", ",
                                "display users : ", ""));
        }
        consolePrinter.print(text);
    }
}