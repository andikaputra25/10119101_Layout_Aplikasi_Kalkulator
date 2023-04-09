package com.example.layoutaplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {



    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_koma,
           clear_btn, percent_btn, delete_btn, btn_bagi, btn_kali, btn_kurang, btn_tambah, btn_hasil;
    TextView txt_inputText, txt_outputText;
    String process;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_inputText = findViewById(R.id.txt_inputText);
        txt_outputText= findViewById(R.id.txt_outputText);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn_tambah = findViewById(R.id.btn_tambah);
        btn_kurang = findViewById(R.id.btn_kurang);
        btn_bagi = findViewById(R.id.btn_bagi);
        btn_kali = findViewById(R.id.btn_kali);

        btn_koma = findViewById(R.id.btn_koma);
        clear_btn = findViewById(R.id.clear_btn);
        percent_btn = findViewById(R.id.percent_btn);
        delete_btn = findViewById(R.id.delete_btn);

        btn_hasil = findViewById(R.id.btn_hasil);


        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_inputText.setText("");
                txt_outputText.setText("");
            }
        });

        btn_koma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + ",");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "9");
            }
        });


        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "+");
            }
        });

        btn_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "-");
            }
        });

        btn_bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "÷");
            }
        });

        btn_kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "x");
            }
        });

        percent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();
                txt_inputText.setText(process + "%");
            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = txt_inputText.getText().toString();
                int input = word.length();
                if (input > 0 ) {
                    txt_inputText.setText(word.substring(0, input - 1));
                }
            }
        });

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = txt_inputText.getText().toString();

                process = process.replaceAll("x", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("÷", "/");


                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript", 1, null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                txt_outputText.setText(finalResult);
            }
        });
    }
}