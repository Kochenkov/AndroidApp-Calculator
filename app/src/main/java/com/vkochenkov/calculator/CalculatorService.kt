package com.vkochenkov.calculator

class CalculatorService(var numberStr: String = "0", var logStr: String = "") {
    private var firstNumber = 0f
    private var secondNumber = 0f
    private var operation: Operation = Operation.DEFAULT
    private var numberInputCompleted: Boolean = false

    fun addSymbol(viewId: Int) {
        if (numberInputCompleted) {
            numberStr = ""
            numberInputCompleted = false
        }
        if (numberStr == "0") {
            numberStr = ""
        }
        if (numberStr.length < 12) {
            when (viewId) {
                R.id.btnZero -> numberStr += "0"
                R.id.btnOne -> numberStr += "1"
                R.id.btnTwo -> numberStr += "2"
                R.id.btnThree -> numberStr += "3"
                R.id.btnFour -> numberStr += "4"
                R.id.btnFive -> numberStr += "5"
                R.id.btnSix -> numberStr += "6"
                R.id.btnSeven -> numberStr += "7"
                R.id.btnEight -> numberStr += "8"
                R.id.btnNine -> numberStr += "9"
                R.id.btnPoint -> {
                    if (numberStr == "") {
                        numberStr = "0"
                    }
                    if (!numberStr.contains(".")) {
                        numberStr += "."
                    }
                }
            }
        }
    }

    fun delSymbols(viewId: Int) {
        when (viewId) {
            R.id.btnDel -> {
                if (numberStr.contains("Infinity").not() and numberStr.contains("NaN").not()) {
                    numberStr =
                            if (numberStr.length > 1) {
                                numberStr.substring(0, numberStr.length - 1)
                            } else {
                                "0"
                            }
                }
            }
            R.id.btnClear -> {
                numberStr = "0"
                logStr = ""
            }
        }
    }

    fun selectOperation(viewId: Int) {
        if (numberStr != "") {
            when (viewId) {
                R.id.btnChangeSign -> {
                    //todo
                }
                R.id.btnPlus -> {
                    firstNumber = tryNumberStringToFloat()
                    operation = Operation.ADDITION
                    logStr = firstNumber.toString() + operation.symbol
                }
                R.id.btnMinus -> {
                    firstNumber = tryNumberStringToFloat()
                    operation = Operation.SUBTRACTION
                    logStr = firstNumber.toString() + operation.symbol
                }
                R.id.btnMultiply -> {
                    firstNumber = tryNumberStringToFloat()
                    operation = Operation.MULTIPLICATION
                    logStr = firstNumber.toString() + operation.symbol
                }
                R.id.btnDivision -> {
                    firstNumber = tryNumberStringToFloat()
                    operation = Operation.DIVISION
                    logStr = firstNumber.toString() + operation.symbol
                }
                R.id.btnEqual -> {
                    secondNumber = tryNumberStringToFloat()
                    calculate(operation)
                    if (operation !== Operation.EQUALS) {
                        logStr = firstNumber.toString() + operation.symbol + secondNumber + Operation.EQUALS.symbol + numberStr
                    }
                    operation = Operation.EQUALS
                }
            }
            numberInputCompleted = true
        } else {
            logStr = "Something went wrong!"
        }
    }

    private fun calculate(operation: Operation) {
        var answer = secondNumber
        when (operation) {
            Operation.ADDITION -> answer = firstNumber + secondNumber
            Operation.SUBTRACTION -> answer = firstNumber - secondNumber
            Operation.MULTIPLICATION -> answer = firstNumber * secondNumber
            Operation.DIVISION -> answer = firstNumber / secondNumber
        }
        numberStr = java.lang.Float.toString(answer)
    }

    private fun tryNumberStringToFloat(): Float {
        var targetField: Float = 0f
        try {
            targetField = numberStr.toFloat()
        } catch (e: NumberFormatException) {
            logStr = "Something went wrong!"
        }
        return targetField
    }
}