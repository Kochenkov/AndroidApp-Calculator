package com.vkochenkov.calculator;

import lombok.Getter;

@Getter
public class Calculator {

    private float firstNumber;
    private float secondNumber;
    private String numberStr = "0";
    private String stateStr = "";
    private Operation operation;

    public Calculator() {
        this.operation = Operation.DEFAULT;
    }

    public void addSymbol(int viewId) {
        if (operation!= Operation.DEFAULT) {
            numberStr = "";
        }
        if (numberStr.equals("0")) {
            numberStr = "";
        }
        if (numberStr.length() < 12) {
            switch (viewId) {
                case R.id.btnZero:
                    numberStr += "0";
                    break;
                case R.id.btnOne:
                    numberStr += "1";
                    break;
                case R.id.btnTwo:
                    numberStr += "2";
                    break;
                case R.id.btnThree:
                    numberStr += "3";
                    break;
                case R.id.btnFour:
                    numberStr += "4";
                    break;
                case R.id.btnFive:
                    numberStr += "5";
                    break;
                case R.id.btnSix:
                    numberStr += "6";
                    break;
                case R.id.btnSeven:
                    numberStr += "7";
                    break;
                case R.id.btnEight:
                    numberStr += "8";
                    break;
                case R.id.btnNine:
                    numberStr += "9";
                    break;
                case R.id.btnPoint:
                    if (numberStr.equals("")) {
                        numberStr = "0";
                    }
                    if (!numberStr.contains(".")) {
                        numberStr += ".";
                    }
                    break;
            }
        }
    }

    public void delSymbols(int viewId) {
        switch (viewId) {
            case R.id.btnDel:
                if (numberStr.length() > 0) {
                    numberStr = numberStr.substring(0, numberStr.length() - 1);
                }
                break;
            case R.id.btnClear:
                numberStr = "";
                break;
        }
    }

    public void selectOperation(int viewId) {
        //todo - креш если выбрать минус после любой операции
        switch (viewId) {
            case R.id.btnPlus:
                firstNumber = Float.parseFloat(numberStr);
                operation = Operation.ADDITION;
                break;
            case R.id.btnMinus:
                firstNumber = Float.parseFloat(numberStr);
                operation = Operation.SUBTRACTION;
                break;
            case R.id.btnMultiply:
                firstNumber = Float.parseFloat(numberStr);
                operation = Operation.MULTIPLICATION;
                break;
            case R.id.btnDivision:
                firstNumber = Float.parseFloat(numberStr);
                operation = Operation.DIVISION;
                break;
            case R.id.btnEqual:
                secondNumber = Float.parseFloat(numberStr);
                operation = Operation.EQUALS;
                calculate(operation);
                break;
        }
    }

    private void calculate(Operation operation) {
        float answer;
        switch (operation) {
            case ADDITION:
                answer = firstNumber + secondNumber;
                numberStr = Float.toString(answer);
                break;
            case SUBTRACTION:
                answer = firstNumber - secondNumber;
                numberStr = Float.toString(answer);
                break;
            case MULTIPLICATION:
                answer = firstNumber * secondNumber;
                numberStr = Float.toString(answer);
                break;
            case DIVISION:
                answer = firstNumber / secondNumber;
                numberStr = Float.toString(answer);
                break;
        }
    }
}