package com.newlight77.kata.user.search;

import com.newlight77.kata.user.search.display.ResultDisplayer;

import java.util.List;
import java.util.stream.Collectors;

public class UserSearchService {
    private ResultDisplayer displayer;
    private UserRepository repository;

    public UserSearchService(UserRepository repository, ResultDisplayer displayer) {
        this.repository = repository;
        this.displayer = displayer;
    }

    public List<User> search(UserSearchCriteria criteria) {
        List<User> result;
        result = filterUser(criteria, repository.getUsers());
        displayer.display(result);
        return result;
    }

    private List<User> filterUser(UserSearchCriteria criteria, List<User> users) {
        return users.stream()
                .filter(u -> nameMatched(criteria, u))
                .filter(u -> ageMatched(criteria, u))
                .collect(Collectors.toList());
    }

    private boolean nameMatched(UserSearchCriteria criteria, User user) {
        if (criteria.getName() != null) {
            return user.getFirstname().toLowerCase().contains(criteria.getName().toLowerCase())
                    || user.getLastname().toLowerCase().contains(criteria.getName().toLowerCase());
        }
        return true;
    }

    private boolean ageMatched(UserSearchCriteria criteria, User user) {
        if (criteria.getAge() != null) {
            return criteria.getAge() == user.getAge();
        }
        return true;
    }
}
