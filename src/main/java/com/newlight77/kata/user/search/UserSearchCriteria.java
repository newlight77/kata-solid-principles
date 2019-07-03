package com.newlight77.kata.user.search;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserSearchCriteria {
    private String name;
    private Integer age = -1;
}
