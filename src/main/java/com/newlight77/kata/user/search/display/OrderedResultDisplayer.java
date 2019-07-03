package com.newlight77.kata.user.search.display;

import com.newlight77.kata.user.search.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderedResultDisplayer implements ResultDisplayer {

    @Override
    public void displayInNaturalOrder(List<User> users) {
        String text = users.stream()
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "displaying in natural order :           ", ""));
        System.out.println(text);
    }

    @Override
    public void displayOrderByLastname(List<User> users) {
        String text = users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "displaying users ordered by age :               ", ""));
        System.out.println(text);
    }

    @Override
    public void displayOrderByFirstname(List<User> users) {
        throw new NotImplementedException();
    }

    @Override
    public void displayOrderedByAge(List<User> users) {
        String text = users.stream()
                .sorted(Comparator.comparing(User::getLastname))
                .map(u -> u.getFirstname() + " " + u.getLastname())
                .collect(Collectors.joining(", ", "displaying users ordered by lastname:   ", ""));
        System.out.println(text);
    }
}
