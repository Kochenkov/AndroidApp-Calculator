package com.vkochenkov.calculator;

import lombok.Getter;

@Getter
public class Calculator {

    private float firstNumber;
    private float secondNumber;
    private String numberStr = "";
    private State state;


    public Calculator() {
        this.state = State.INITIAL_INPUT;
    }

    public void addSymbol(int viewId) {
        if (numberStr.length()<10) {
            switch (viewId) {
                case R.id.btnZero:
                    if (!numberStr.equals("0")) {
                        numberStr += "0";
                    }
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
                    numberStr += ".";
                    break;
            }
        }
    }

    public void delSymbols(int viewId) {
        switch (viewId) {
            case R.id.btnDel:
                if (numberStr.length()>0) {
                    numberStr = numberStr.substring(0, numberStr.length()-1);
                }
                break;
            case R.id.btnClear:
                numberStr = "";
                break;
        }
    }
}
