package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class UserSearchService {
    private UserRepository repository;
    private ResultDisplayer displayer;
    private ResultOrderer orderer;

    public List<User> search(UserSearchCriteria criteria) {
        List<User> result = filterUser(criteria, repository.getUsers());
        orderer.sort(result);
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
