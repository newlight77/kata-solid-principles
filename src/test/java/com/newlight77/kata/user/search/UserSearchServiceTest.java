package com.newlight77.kata.user.search;

import com.newlight77.kata.user.search.display.ResultDisplayer;
import com.newlight77.kata.user.search.display.ResultDisplayerNaturalOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserSearchServiceTest {

    @Test
    public void should_find_users_by_name() {
        // arrange
        UserRepository repository = new UserRepositoryStub();
        ResultDisplayer displayer = new ResultDisplayerNaturalOrder();
        UserSearchService service = new UserSearchService(repository, displayer);

        // act
        List<User> result = service.search(UserSearchCriteria.builder().name("t").build());

        // assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals("Kong", result.get(0).getFirstname());
        Assertions.assertEquals("Peter", result.get(1).getFirstname());
        Assertions.assertEquals("Mathieu", result.get(2).getFirstname());
        Assertions.assertEquals("Manuel", result.get(3).getFirstname());
    }

    @Test
    public void should_find_users_by_age() {
        // arrange
        UserRepository repository = new UserRepositoryStub();
        ResultDisplayer displayer = new ResultDisplayerNaturalOrder();
        UserSearchService service = new UserSearchService(repository, displayer);

        // act
        List<User> result = service.search(UserSearchCriteria.builder().age(37).build());

        // assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Kong", result.get(0).getFirstname());
    }

    @Test
    public void should_not_find_users_with_no_matching_criteria() {
        // arrange
        UserRepository repository = new UserRepositoryStub();
        ResultDisplayer displayer = new ResultDisplayerNaturalOrder();
        UserSearchService service = new UserSearchService(repository, displayer);

        // act
        List<User> result = service.search(UserSearchCriteria.builder().name("tttt").age(55).build());

        // assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }
}
