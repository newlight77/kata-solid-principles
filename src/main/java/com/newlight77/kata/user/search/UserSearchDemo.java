package com.newlight77.kata.user.search;

import java.util.Arrays;
import java.util.List;

public class UserSearchDemo {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                User.builder().uid(2).firstname("Kong").lastname("To").age(37).build(),
                User.builder().uid(1).firstname("Peter").lastname("Ly").age(21).build(),
                User.builder().uid(5).firstname("Mathieu").lastname("Nguyen").age(18).build(),
                User.builder().uid(3).firstname("Manuel").lastname("Descartes").age(43).build(),
                User.builder().uid(4).firstname("Sabrina").lastname("Van Der Valk").age(52).build()
        );

        System.out.println("---------------    Starting with these users    -----------------");
        users.forEach(u -> System.out.println("user -> " + u));
        System.out.println("---------------    -------------------------    -----------------");

        UserRepository repository = new UserRepository(users);
        UserSearchService service = new UserSearchService(repository);
        UserSearchClient client = new UserSearchClient(service);

        List<User> result = client.search(UserSearchCriteria.builder().name("t").build());

        service.display(result, UserSearchService.ORDER_TYPE.BY_AGE);
    }
}