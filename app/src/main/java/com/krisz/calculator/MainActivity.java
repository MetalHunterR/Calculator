package com.krisz.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText first;
    EditText second;

    Button operationAdd;
    Button operationSub;
    Button operationMulti;
    Button operationDiv;

    TextView resultText;

    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Komponensek beállítása
        first = (EditText) findViewById(R.id.firstPart);
        second = (EditText) findViewById(R.id.secondPart);

        operationAdd = (Button) findViewById(R.id.operator_plus);
        operationSub = (Button) findViewById(R.id.operator_minus);
        operationMulti = (Button) findViewById(R.id.operator_multi);
        operationDiv = (Button) findViewById(R.id.operator_div);

        resultText = (TextView) findViewById(R.id.endResult);

        // Clickek bindelése
        operationAdd.setOnClickListener(this);
        operationSub.setOnClickListener(this);
        operationMulti.setOnClickListener(this);
        operationDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float numberOne;
        float numberTwo;
        float result = 0;

        // Valami üres?
        if(TextUtils.isEmpty(first.getText().toString())
                || TextUtils.isEmpty(second.getText().toString())) {
            return;
        }

        numberOne = Float.parseFloat(first.getText().toString());
        numberTwo = Float.parseFloat(second.getText().toString());

        switch (v.getId()) {
            case R.id.operator_plus:
                    operator = "+";
                    result = numberOne + numberTwo;
                break;
            case R.id.operator_minus:
                    operator = "-";
                    result = numberOne - numberTwo;
                break;
            case R.id.operator_multi:
                    operator = "*";
                    result = numberOne * numberTwo;
                break;
            case R.id.operator_div:
                    operator = "/";
                    result = numberOne / numberTwo;
                break;
            default:
                break;
        }
        resultText.setText(numberOne + " " + operator + " " + numberTwo + " = " + result);
    }

    // Menü létrehozás (Első fajta)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");

        return super.onCreateOptionsMenu(menu);
    }

    // Click esemény kezelés
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                    first.setText("");
                    second.setText("");
                    resultText.setText("");
                break;
            case MENU_QUIT_ID:
                    finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
