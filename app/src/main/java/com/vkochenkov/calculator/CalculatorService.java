package com.vkochenkov.calculator;

import lombok.Getter;

@Getter
public class CalculatorService {

    private float firstNumber;
    private float secondNumber;

    private String numberStr = "0";
    private String logStr = "";

    private Operation operation;
    private boolean numberInputCompleted;

    public CalculatorService() {
        this.operation = Operation.DEFAULT;
        this.numberInputCompleted = false;
    }

    public void addSymbol(int viewId) {
        if (numberInputCompleted) {
            numberStr = "";
            numberInputCompleted = false;
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
                if (numberStr.length() > 1) {
                    numberStr = numberStr.substring(0, numberStr.length() - 1);
                } else {
                    numberStr = "0";
                }
                break;
            case R.id.btnClear:
                numberStr = "0";
                logStr = "";
                break;
        }
    }

    public void selectOperation(int viewId) {
        if (!numberStr.equals("")) {
            switch (viewId) {
                case R.id.btnChangeSign:
                    //todo
                    break;
                case R.id.btnPlus:
                    firstNumber = Float.parseFloat(numberStr);
                    operation = Operation.ADDITION;
                    logStr = firstNumber + operation.getSymbol();
                    break;
                case R.id.btnMinus:
                    firstNumber = Float.parseFloat(numberStr);
                    operation = Operation.SUBTRACTION;
                    logStr = firstNumber + operation.getSymbol();
                    break;
                case R.id.btnMultiply:
                    firstNumber = Float.parseFloat(numberStr);
                    operation = Operation.MULTIPLICATION;
                    logStr = firstNumber + operation.getSymbol();
                    break;
                case R.id.btnDivision:
                    firstNumber = Float.parseFloat(numberStr);
                    operation = Operation.DIVISION;
                    logStr = firstNumber + operation.getSymbol();
                    break;
                case R.id.btnEqual:
                    secondNumber = Float.parseFloat(numberStr);
                    calculate(operation);
                    if (operation!=Operation.EQUALS) {
                        logStr = firstNumber + operation.getSymbol() + secondNumber + Operation.EQUALS.getSymbol() + numberStr;
                    }
                    operation = Operation.EQUALS;
                    break;
            }
            numberInputCompleted = true;
        } else {
            logStr = "Something went wrong!";
        }

    }

    private void calculate(Operation operation) {
        float answer = secondNumber;
        switch (operation) {
            case ADDITION:
                answer = firstNumber + secondNumber;
                break;
            case SUBTRACTION:
                answer = firstNumber - secondNumber;
                break;
            case MULTIPLICATION:
                answer = firstNumber * secondNumber;
                break;
            case DIVISION:
                answer = firstNumber / secondNumber;
                break;
        }
        numberStr = Float.toString(answer);

    }
}