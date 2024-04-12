package com.example.networkreconnaissance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DashboardActivity extends AppCompatActivity {

    TextView unameTxt;
    Button signOutBtn, btnScan;
    FileInputStream fistream;
    Intent i, x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        unameTxt = (TextView) findViewById(R.id.txtUname);
        signOutBtn = (Button) findViewById(R.id.btnSignOut);
        btnScan = (Button) findViewById(R.id.btnScan);

        i = new Intent(this, MainActivity.class);
        x = new Intent(this, MainWifi.class);

        try {
            fistream = openFileInput("user.txt");
            StringBuffer sBuff = new StringBuffer();

            int ctr;
            while((ctr = fistream.read()) != -1) {
                sBuff.append((char) ctr);
            }
            fistream.close();

            String hold[] = sBuff.toString().split("\n");

            unameTxt.setText(hold[0]);
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Please insert a file!");
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            System.out.println("Input Output Error! Include an input!");
            ioe.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Major error occurred! Please contact devs!");
            e.printStackTrace();
        }

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Successfully Logged Out", Toast.LENGTH_SHORT).show();
            }
        });

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(x);
            }
        });

        //Code for other functionalities below

    }
}