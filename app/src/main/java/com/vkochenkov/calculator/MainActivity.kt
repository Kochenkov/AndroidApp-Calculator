package com.vkochenkov.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val calculator = CalculatorService()

    lateinit var numberText: TextView
    lateinit var logText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        //start
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        numberText = findViewById(R.id.tvMain)
        numberText.setText(calculator.numberStr)
        logText = findViewById(R.id.tvFurther)

        val symbolicButtonIds = intArrayOf(
                R.id.btnZero,
                R.id.btnOne,
                R.id.btnTwo,
                R.id.btnThree,
                R.id.btnFour,
                R.id.btnFive,
                R.id.btnSix,
                R.id.btnSeven,
                R.id.btnEight,
                R.id.btnNine,
                R.id.btnPoint
        )
        val operationButtonIds = intArrayOf(
                R.id.btnPlus,
                R.id.btnMinus,
                R.id.btnMultiply,
                R.id.btnDivision,
                R.id.btnEqual,
                R.id.btnChangeSign
        )
        val clearButtonIds = intArrayOf(
                R.id.btnClear,
                R.id.btnDel
        )

        //set OnClickListeners for buttons
        for (buttonId in symbolicButtonIds) {
            findViewById<View>(buttonId).setOnClickListener(symbolicButtonsListener)
        }
        for (buttonId in operationButtonIds) {
            findViewById<View>(buttonId).setOnClickListener(operationButtonsListener)
        }
        for (buttonId in clearButtonIds) {
            findViewById<View>(buttonId).setOnClickListener(clearButtonsListener)
        }
    }

    //create OnClickListeners for buttons
    private val symbolicButtonsListener = View.OnClickListener { v ->
        calculator.addSymbol(v.id)
        showTexts()
    }
    private val operationButtonsListener = View.OnClickListener { v ->
        calculator.selectOperation(v.id)
        showTexts()
    }
    private val clearButtonsListener = View.OnClickListener { v ->
        calculator.delSymbols(v.id)
        showTexts()
    }

    private fun showTexts() {
        numberText.text = calculator.numberStr
        logText.text = calculator.logStr
    }
}