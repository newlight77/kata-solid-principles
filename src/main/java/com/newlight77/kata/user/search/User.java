package com.newlight77.kata.user.search;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    private int uid;
    private String lastname;
    private String firstname;
    private int age;
    private String email;
    private String address;
    private String phone;
}
