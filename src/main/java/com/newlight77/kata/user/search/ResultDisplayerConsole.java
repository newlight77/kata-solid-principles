package com.newlight77.kata.user.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ResultDisplayerConsole implements ResultDisplayer {
    @Getter
    Printer printer;
}