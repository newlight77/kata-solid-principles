package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UserRepository {
    @Getter
    List<User> users;
}

