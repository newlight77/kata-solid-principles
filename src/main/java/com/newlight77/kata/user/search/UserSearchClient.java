package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserSearchClient {

    private UserSearchService service;
    private ResultOrderer orderer;
    private ResultDisplayer displayer;

    public List<User> search(UserSearchCriteria criteria) {
        List<User> result = service.search(criteria);
        orderer.sort(result);
        displayer.display(result);
        return result;
    }
}
