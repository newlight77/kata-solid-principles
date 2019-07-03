package com.newlight77.kata.user.search.display;

import com.newlight77.kata.user.search.User;

import java.util.List;
import java.util.stream.Collectors;

public class ResultDisplayerNaturalOrder implements ResultDisplayer {
    @Override
    public void display(List<User> users) {
        String text = users.stream()
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "technical layer requires to display in natural order :           ", ""));
        System.out.println(text);
    }
}
