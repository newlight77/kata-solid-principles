package com.newlight77.kata.user.search;

import java.util.List;
import java.util.stream.Collectors;

public class UserSearchService {
    private final ResultDisplayer resultDisplayer = new ResultDisplayer();

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
        resultDisplayer.display(result, ResultDisplayer.ORDER_TYPE.DEFAULT);
        return result;
    }
}
