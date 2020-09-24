package com.vkochenkov.calculator;

import lombok.Getter;

@Getter
public enum Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    EQUALS("="),
    DEFAULT("");

    String symbol;

    private Operation(String symbol) {
        this.symbol = symbol;
    }
}
