package com.newlight77.kata.user.search;

import com.newlight77.kata.user.search.display.ResultDisplayer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserSearchClient {

    private UserSearchService service;
    private ResultDisplayer displayer;

    public List<User> search(UserSearchCriteria criteria) {
        List<User> result = service.search(criteria);
        displayer.displayOrderByLastname(result);
        return result;
    }
}
