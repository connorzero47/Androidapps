package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class Length extends AppCompatActivity {
    EditText User1, User2, User3, User4;
    TextView Result1, Result2, Result3, Result4;
    Button button1, button2, button3, button4, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        User1 = findViewById(R.id.User1);
        User2 = findViewById(R.id.User2);
        User3 = findViewById(R.id.User3);
        User4 = findViewById(R.id.User4);

        Result1 = findViewById(R.id.Result1);
        Result2 = findViewById(R.id.Result2);
        Result3 = findViewById(R.id.Result3);
        Result4 = findViewById(R.id.Result4);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View c) {
                openMainActivity();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View d) {
                String Inches = User1.getText().toString();

                double Inch = Double.parseDouble(Inches);
                double Cm = Inch * 2.54;
                Result1.setText(Double.toString(Cm));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                String Centi = User2.getText().toString();

                double Cent = Double.parseDouble(Centi);
                double In = Cent/2.54;
                Result2.setText(Double.toString(In));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View f) {
                String Kilo = User3.getText().toString();

                double Km = Double.parseDouble(Kilo);
                double Mi = Km/1.609;
                Result3.setText(Double.toString(Mi));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View g) {
                String Miles = User4.getText().toString();

                double Mile = Double.parseDouble(Miles);
                double Mil = Mile * 1.609;
                Result4.setText(Double.toString(Mil));
            }
        });

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}