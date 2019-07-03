package com.newlight77.kata.user.search.display;


import com.newlight77.kata.user.search.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultDisplayerOrderByLastname implements ResultDisplayer {
    @Override
    public void display(List<User> users) {
        String text = users.stream()
                .sorted(Comparator.comparing(User::getLastname))
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "technical layer requires to display users ordered by lastname:   ", ""));
        System.out.println(text);
    }
}
