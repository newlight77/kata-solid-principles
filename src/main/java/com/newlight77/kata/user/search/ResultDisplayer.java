package com.newlight77.kata.user.search;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultDisplayer {

    enum ORDER_TYPE {
        BY_LASTNAME,
        BY_AGE,
        DEFAULT;
    }

    public ResultDisplayer() {
    }

    public void display(List<User> users, ORDER_TYPE orderType) {
        String text = "";
        switch (orderType) {
            case BY_LASTNAME:
                text = users.stream()
                        .sorted(Comparator.comparing(User::getLastname))
                        .map(u -> u.getFirstname() + " " + u.getLastname())
                        .collect(Collectors.joining(", ",
                                "displaying users : ", ""));
                break;
            case BY_AGE:
                text = users.stream()
                        .sorted(Comparator.comparing(User::getAge))
                        .map(u -> u.getFirstname() + " " + u.getLastname())
                        .collect(Collectors.joining(", ",
                                "displaying users : ", ""));
                break;
            case DEFAULT:
            default:
                text = users.stream()
                        .map(u -> u.getFirstname() + " " + u.getLastname())
                        .collect(Collectors.joining(", ",
                                "displaying users : ", ""));
        }
        System.out.println(text);
    }
}