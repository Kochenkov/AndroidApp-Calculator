package com.vkochenkov.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator = new Calculator();

    private TextView tvMain;
    private TextView tvFurther;

    //create OnClickListeners for buttons
    private View.OnClickListener symbolicButtonsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calculator.addSymbol(v.getId());
            tvMain.setText(calculator.getNumberStr());
        }
    };
    private View.OnClickListener operationButtonsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calculator.selectOperation(v.getId());
            tvMain.setText(calculator.getNumberStr());
            tvFurther.setText(calculator.getStateStr());
        }
    };
    private View.OnClickListener clearButtonsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calculator.delSymbols(v.getId());
            tvMain.setText(calculator.getNumberStr());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //start
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        tvMain = findViewById(R.id.tvMain);
        tvMain.setText(calculator.getNumberStr());
        tvFurther = findViewById(R.id.tvFurther);
        int[] symbolicButtonIds = new int[]{
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
                R.id.btnPoint,
        };
        int[] operationButtonIds = new int[]{
                R.id.btnPlus,
                R.id.btnMinus,
                R.id.btnMultiply,
                R.id.btnDivision,
                R.id.btnEqual
        };
        int[] clearButtonIds = new int[]{
                R.id.btnClear,
                R.id.btnDel
        };

        //set OnClickListeners for buttons
        for (int buttonId : symbolicButtonIds) {
            findViewById(buttonId).setOnClickListener(symbolicButtonsListener);
        }
        for (int buttonId : operationButtonIds) {
            findViewById(buttonId).setOnClickListener(operationButtonsListener);
        }
        for (int buttonId : clearButtonIds) {
            findViewById(buttonId).setOnClickListener(clearButtonsListener);
        }
    }
}