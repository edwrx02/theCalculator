package com.example.edwin.thecalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private String text, operation;
    private int number1, number2;
    private Button n0, n1, n2, n3, n4, n5, n6, n7, n8, n9,
            plus, divide, equal, period, minus, multiply, delete, science;
    private TextView display;
    private boolean second;
    private double decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    number1 = 0;
    number2 = 0;
    text = "";
    operation = "nothing";
    second = false;
    decimal = 0.0;

    display = (TextView) findViewById(R.id.display);

    Intent intent = getIntent();

        period = (Button)findViewById(R.id.period);
        period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2Activity.class);
                intent.putExtra("num", number1);
                startActivity(intent);
            }

        });






        n0 = (Button)findViewById(R.id.n0);
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (second == false){
                        numbers(0);}
                    else{numbers2(0);}
            }
        });

        n1 = (Button)findViewById(R.id.n1);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(1);}
                else{numbers2(1);}
            }
        });

        n2 = (Button)findViewById(R.id.n2);
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(2);}
                else{numbers2(2);}
            }
        });

        n3 = (Button)findViewById(R.id.n3);
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(3);}
                else{numbers2(3);}
            }
        });


        n4 = (Button)findViewById(R.id.n4);
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(4);}
                else{numbers2(4);}
            }
        });

        n5 = (Button)findViewById(R.id.n5);
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(5);}
                else{numbers2(5);}
            }
        });

        n6 = (Button)findViewById(R.id.n6);
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(6);}
                else{numbers2(6);}
            }
        });

        n7 = (Button)findViewById(R.id.n7);
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(7);}
                else{numbers2(7);}
            }
        });

        n8 = (Button)findViewById(R.id.n8);
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(8);}
                else{numbers2(8);}
            }
        });

        n9 = (Button)findViewById(R.id.n9);
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (second == false){
                    numbers(9);}
                else{numbers2(9);}
            }
        });

        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleting();
            }
        });

        plus = (Button)findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("+");
            }
        });

        multiply = (Button)findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("*");
            }
        });

        minus = (Button)findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("-");
            }
        });

        divide = (Button)findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("/");
            }
        });



        equal = (Button)findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal();
            }
        });


    }

    public void numbers(int i){

        if (number1 == 0 && i == 0){
            text = Integer.toString(i);
        }
        else{
            text = text+Integer.toString(i);
        }

        display.setText(text);
        number1 = Integer.valueOf(text).intValue();
    }

    public void numbers2(int i){

        if (number2 == 0 && i == 0){
            text = Integer.toString(i);
        }
        else{
            text = text+Integer.toString(i);
        }

        display.setText(text);
        number2 = Integer.valueOf(text).intValue();
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
