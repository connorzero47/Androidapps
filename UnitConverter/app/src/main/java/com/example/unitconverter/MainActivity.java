package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button LengthC, VolumeC;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LengthC = findViewById(R.id.lengthC);
        VolumeC = findViewById(R.id.VolumeC);

        VolumeC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View a) {
                openVolume();
            }
        });

        LengthC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View b) {
                openLength();
            }
        });


    }

    public void openLength() {
        Intent intent = new Intent(this, Length.class);
        startActivity(intent);
    }

    public void openVolume() {
        Intent intent = new Intent(this, Volume.class);
        startActivity(intent);
    }

}