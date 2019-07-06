package com.newlight77.kata.user.search;

import lombok.Getter;

public class ConsolePrinterSpy extends ConsolePrinter {
    @Getter
    private String text;
    @Override
    public void print(String text) {
        this.text = text;
        System.out.println(text);
    }
}
