package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    EditText email, pass; Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        button = findViewById(R.id.button);

        button.setBackground(getResources().getDrawable(R.drawable.bg_enabled_f_btn));

        button.setEnabled(false);

        email.addTextChangedListener(textWatcher);
        pass.addTextChangedListener(textWatcher);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().equals("admin") && pass.getText().equals("admin")){
                    email.setVisibility(View.INVISIBLE);
                    pass.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    findViewById(R.id.layout_txt).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView3).setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();

                }else if (!email.getText().equals("admin") && !pass.getText().equals("admin")){
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String e = email.getText().toString();
            String p = pass.getText().toString();

            if (!e.isEmpty() && !p.isEmpty()){

                button.setBackground(getResources().getDrawable(R.drawable.bg_btn));
                button.setEnabled(true);

            }else {
                button.setBackground(getResources().getDrawable(R.drawable.bg_enabled_f_btn));
                button.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}