package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class ResultDisplayerNoOrder implements ResultDisplayer {

    @Getter
    private ConsolePrinter consolePrinter;

    @Override
    public void sort(List<User> users) {
        //throw new UnsupportedOperationException("No sorting allow here");
    }
}