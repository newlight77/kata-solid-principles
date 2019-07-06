package com.newlight77.kata.user.search;

import java.util.Comparator;
import java.util.List;

public class ResultOrderByFirstname implements ResultOrderer {
    @Override
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(User::getFirstname));
    }
}