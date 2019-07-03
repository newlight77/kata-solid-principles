package com.newlight77.kata.user.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class UserSearchClientTest {

    List<User> users = Arrays.asList(
            User.builder().uid(2).firstname("Kong").lastname("To").age(37).email("kto@wesquad.io").build(),
            User.builder().uid(1).firstname("Peter").lastname("Ly").age(21).email("ply@wesquad.io").build(),
            User.builder().uid(5).firstname("Mathieu").lastname("Nguyen").age(18).email("mng@wesquad.io").build(),
            User.builder().uid(3).firstname("Manuel").lastname("Descartes").age(43).email("mde@wesquad.io").build(),
            User.builder().uid(4).firstname("Sabrina").lastname("Van Der Valk").age(52).email("sdv@wesquad.io").build()
    );

    @Test
    public void should_find_users_by_name() {
        // arrange
        UserSearchService service = Mockito.mock(UserSearchService.class);
        Mockito.when(service.search(Mockito.isA(UserSearchCriteria.class))).thenReturn(users);
        UserSearchClient client = new UserSearchClient(service);

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
