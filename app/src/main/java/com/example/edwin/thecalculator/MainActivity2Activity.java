package com.example.edwin.thecalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;


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
        number1 = intent.getIntExtra("num", 0);
        text = Integer.toString(number1);
        display.setText(text);

        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleting();
            }
        });


        sin = (Button)findViewById(R.id.sin);
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("sin");
            }
        });

        cos = (Button)findViewById(R.id.cos);
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("cos");
            }
        });

        tan = (Button)findViewById(R.id.tan);
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("tan");
            }
        });

        ii = (Button)findViewById(R.id.i);
        ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("i");
            }
        });

        ln = (Button)findViewById(R.id.ln);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("ln");
            }
        });

        log = (Button)findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("log");
            }
        });

        pi = (Button)findViewById(R.id.pi);
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("pi");
            }
        });

        ee = (Button)findViewById(R.id.e);
        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("e");
            }
        });

        percent = (Button)findViewById(R.id.percent);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("percent");
            }
        });

        fact = (Button)findViewById(R.id.fact);
        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("fact");
            }
        });

        root = (Button)findViewById(R.id.root);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("root");
            }
        });

        square = (Button)findViewById(R.id.exp);
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("square");
            }
        });

        left = (Button)findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("left");
            }
        });

        right = (Button)findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations("right");
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
        cal();
    }

    public void cal() {
        text = "";
        if (operation == "sin") {
            decimal = (double)number1;
            decimal = Math.sin(decimal);
            text = Double.toString(decimal);

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
