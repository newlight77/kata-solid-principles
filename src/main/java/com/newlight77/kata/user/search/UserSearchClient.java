package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserSearchClient {

    private UserSearchService service;

    public List<User> search(UserSearchCriteria criteria) {
        List<User> result = service.search(criteria);
        new ResultDisplayer().display(result, ResultDisplayer.ORDER_TYPE.BY_LASTNAME);
        return result;
    }
}
