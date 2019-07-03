package com.newlight77.kata.user.search;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserSearchService {
    enum ORDER_TYPE {
        BY_LASTNAME,
        DEFAULT;
    }

    private UserRepository repository;

    public UserSearchService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> search(UserSearchCriteria criteria) {
        List<User> result;
        result = repository.getUsers().stream()
                    .filter(u -> {
                        if (criteria.getName() != null) {
                            return u.getFirstname().toLowerCase().contains(criteria.getName().toLowerCase())
                                || u.getLastname().toLowerCase().contains(criteria.getName().toLowerCase());
                        }
                        return true;
                    })
                    .filter(u -> {
                        if (criteria.getAge() != null) {
                            return criteria.getAge() == u.getAge();
                        }
                        return true;
                    })
                    .collect(Collectors.toList());
        display(result, ORDER_TYPE.DEFAULT);
        return result;
    }

    public void display(List<User> users, ORDER_TYPE orderType) {
        String text = "";
        switch (orderType) {
            case BY_LASTNAME:
                text = users.stream()
                    .sorted(Comparator.comparing(User::getLastname))
                    .map(u -> u.getFirstname() + " " + u.getLastname())
                    .collect(Collectors.joining(", ",
                        "displaying users ordered by lastname: ", ""));
                break;
            case DEFAULT:
            default:
                text = users.stream()
                    .map(u -> u.getFirstname() + " " + u.getLastname())
                    .collect(Collectors.joining(", ",
                        "displaying in natural order : ", ""));
        }
        System.out.println(text);
    }
}
