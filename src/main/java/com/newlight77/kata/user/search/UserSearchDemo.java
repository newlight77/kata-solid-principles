package com.newlight77.kata.user.search;

import java.util.Arrays;
import java.util.List;

public class UserSearchDemo {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                User.builder().uid(2).firstname("Kong").lastname("To").age(37).email("kto@wesquad.io").build(),
                User.builder().uid(1).firstname("Peter").lastname("Ly").age(21).email("ply@wesquad.io").build(),
                User.builder().uid(5).firstname("Mathieu").lastname("Nguyen").age(18).email("mng@wesquad.io").build(),
                User.builder().uid(3).firstname("Manuel").lastname("Descartes").age(43).email("mde@wesquad.io").build(),
                User.builder().uid(4).firstname("Sabrina").lastname("Van Der Valk").age(52).email("sdv@wesquad.io").build()
        );

        System.out.println("---------------    Starting with these users    -----------------");
        users.forEach(u -> System.out.println("user -> " + u));
        System.out.println("---------------    -------------------------    -----------------");

        UserRepository repository = new UserRepository(users);
        ConsolePrinter consolePrinter = new ConsolePrinter();
        ResultDisplayerConsole displayerConsole = new ResultDisplayerConsole(consolePrinter);
        UserSearchService service = new UserSearchService(repository, displayerConsole, new ResultOrderByLastname());
        UserSearchClient client = new UserSearchClient(service, new ResultOrderByEmail(), displayerConsole);

        List<User> result = client.search(UserSearchCriteria.builder().name("t").build());

        new ResultOrderByAge().sort(result);

        displayerConsole.display(result);
    }
}