package com.example.edwin.thecalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {

    private String text, operation;
    private int number1, number2;
    private Button sin, cos, tan, ii, ln, log, pi, ee,
            percent, fact, root, square, left, right, delete;
    private TextView display;
    private boolean second;
    private double decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        number1 = 0;
        number2 = 0;
        text = "";
        operation = "nothing";
        second = false;
        decimal = 0.0;

        display = (TextView) findViewById(R.id.display);

        Intent intent = getIntent();

        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleting();
            }
        });


    }

    public void deleting(){
        text = "";
        number1 = 0;
        number2 = 0;
        decimal = 0.0;
        second = false;
        operation = "nothing";
        display.setText(text);
    }

    public void operations(String s){
        operation = s;
        second = true;
        display.setText(s);
        text = "";
    }

    public void cal() {
        text = "";
        if (operation == "+") {
            number1 = number1 + number2;
            text = Integer.toString(number1);
        }
        else if(operation == "-") {
            number1 = number1 - number2;
            text = Integer.toString(number1);
        }
        else if(operation == "/") {
            decimal = (double)number1/(double)number2;
            text = Double.toString(decimal);
            number1 = (int)decimal;
        }
        else if(operation == "*"){
            number1 = number1*number2;
            text = Integer.toString(number1);
        }

        display.setText(text);
        text = "";
        number2 = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
