package com.msaggik.tenthlessoncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // поля
    private EditText input;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnRem;

    private Calculation calculationAdd;
    private Calculation calculationSub;
    private Calculation calculationMul;
    private Calculation calculationDiv;
    private Calculation calculationRem;

    private float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Лябмда выражения
        calculationAdd = (x, y) -> x + y;
        calculationSub = (x, y) -> x - y;
        calculationMul = (x, y) -> x * y;
        calculationDiv = (x, y) -> x / y;
        calculationRem = (x, y) -> x % y;

        // связь полей представления с разметкой по id
        input = findViewById(R.id.input);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnRem = findViewById(R.id.btnRem);

        // обработаем нажатие кнопок
        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
        btnRem.setOnClickListener(listener);
    }

    // создадим слушатель кнопки и с помощью анонимного класса переопределим метод onClick(View view)
    private View.OnClickListener listener = view -> {

        // считывание введённого пользователем списка чисел
        String dataIn = input.getText().toString();

        // формирование массива чисел
        String[] arrayDataIn = dataIn.split("\\s*,\\s*"); // "\\s*" - регулярное выражение пробелов от 0 до большого числа

        float xInput = Float.parseFloat(arrayDataIn[0]);
        float yInput = Float.parseFloat(arrayDataIn[1]);

        switch (view.getId()) {
            case R.id.btnAdd: result = calculationAdd.calculate(xInput, yInput); break;
            case R.id.btnSub: result = calculationSub.calculate(xInput, yInput); break;
            case R.id.btnMul: result = calculationMul.calculate(xInput, yInput); break;
            case R.id.btnDiv: result = calculationDiv.calculate(xInput, yInput); break;
            case R.id.btnRem: result = calculationRem.calculate(xInput, yInput); break;
        }
        input.setText("" + result);
    };
}