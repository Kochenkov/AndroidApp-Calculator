package com.vkochenkov.calculator

enum class Operation(val symbol: String) {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    EQUALS("="),
    DEFAULT("");
}