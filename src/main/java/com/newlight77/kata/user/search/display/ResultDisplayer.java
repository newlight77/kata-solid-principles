package com.newlight77.kata.user.search.display;

import com.newlight77.kata.user.search.User;

import java.util.List;

public interface ResultDisplayer {
    void displayInNaturalOrder(List<User> users);
    void displayOrderByLastname(List<User> users);
    void displayOrderByFirstname(List<User> users);
    void displayOrderedByAge(List<User> users);
}
