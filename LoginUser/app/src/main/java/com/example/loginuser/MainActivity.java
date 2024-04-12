package com.example.loginuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Login;
    EditText Username, Password;
    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.Login);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Username.getText().toString().equals("ThisIsTheUsername") && Password.getText().toString().equals("ThisIsThePassword")){
                    openLoginSuccess();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Username/Password",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void openLoginSuccess() {
        Intent intent = new Intent(this, LoginSuccess.class);
        startActivity(intent);
    }
}