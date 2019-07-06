package com.newlight77.kata.user.search;

import java.util.Comparator;
import java.util.List;

public class ResultOrderByAge implements ResultOrderer {
    @Override
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(User::getAge));
    }
}