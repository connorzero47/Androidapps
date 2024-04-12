package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Volume extends AppCompatActivity {

    EditText User5, User6, User7, User8;
    TextView Result5, Result6, Result7, Result8;
    Button back, button5, button6, button7, button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        User5 = findViewById(R.id.User5);
        User6 = findViewById(R.id.User6);
        User7 = findViewById(R.id.User7);
        User8 = findViewById(R.id.User8);

        Result5 = findViewById(R.id.Result5);
        Result6 = findViewById(R.id.Result6);
        Result7 = findViewById(R.id.Result7);
        Result8 = findViewById(R.id.Result8);

        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View c) {
                openMainActivity();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View h) {
                String Mil = User5.getText().toString();

                double Mi = Double.parseDouble(Mil);
                double Oz = Mi / 29.574;
                Result5.setText(Double.toString(Oz));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View i) {
                String Ounce = User6.getText().toString();

                double Oun = Double.parseDouble(Ounce);
                double Ml = Oun * 29.574;
                Result6.setText(Double.toString(Ml));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View j) {
                String Lit = User7.getText().toString();

                double Li = Double.parseDouble(Lit);
                double Gallon = Li / 3.785;
                Result7.setText(Double.toString(Gallon));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View k) {
                String Gal = User8.getText().toString();

                double Ga = Double.parseDouble(Gal);
                double Liter = Ga * 3.785;
                Result8.setText(Double.toString(Liter));
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}