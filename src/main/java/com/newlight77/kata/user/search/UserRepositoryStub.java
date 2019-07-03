package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UserRepositoryStub extends UserRepository {
    @Getter
    List<User> users = Arrays.asList(
            User.builder().uid(2).firstname("Kong").lastname("To").age(37).build(),
                User.builder().uid(1).firstname("Peter").lastname("Ly").age(21).build(),
                User.builder().uid(5).firstname("Mathieu").lastname("Nguyen").age(18).build(),
                User.builder().uid(3).firstname("Manuel").lastname("Descartes").age(43).build(),
                User.builder().uid(4).firstname("Sabrina").lastname("Van Der Valk").age(52).build()
        );
}
