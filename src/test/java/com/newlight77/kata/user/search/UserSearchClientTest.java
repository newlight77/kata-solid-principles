package com.newlight77.kata.user.search;

import com.newlight77.kata.user.search.display.ResultDisplayer;
import com.newlight77.kata.user.search.display.ResultDisplayerNaturalOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class UserSearchClientTest {

    private List<User> users = Arrays.asList(
            User.builder().uid(2).firstname("Kong").lastname("To").age(37).build(),
            User.builder().uid(1).firstname("Peter").lastname("Ly").age(21).build(),
            User.builder().uid(5).firstname("Mathieu").lastname("Nguyen").age(18).build(),
            User.builder().uid(3).firstname("Manuel").lastname("Descartes").age(43).build(),
            User.builder().uid(4).firstname("Sabrina").lastname("Van Der Valk").age(52).build()
    );

    @Test
    public void should_find_users_by_name() {
        // arrange
        UserSearchService service = Mockito.mock(UserSearchService.class);
        Mockito.when(service.search(Mockito.isA(UserSearchCriteria.class))).thenReturn(users);
        ResultDisplayer displayer = new ResultDisplayerNaturalOrder();
        UserSearchClient client = new UserSearchClient(service, displayer);

        // act
        List<User> result = client.search(UserSearchCriteria.builder().name("t").build());

        // assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(5, result.size());
        Assertions.assertEquals("Kong", result.get(0).getFirstname());
        Assertions.assertEquals("Peter", result.get(1).getFirstname());
        Assertions.assertEquals("Mathieu", result.get(2).getFirstname());
        Assertions.assertEquals("Manuel", result.get(3).getFirstname());
        Assertions.assertEquals("Sabrina", result.get(4).getFirstname());
    }
}
