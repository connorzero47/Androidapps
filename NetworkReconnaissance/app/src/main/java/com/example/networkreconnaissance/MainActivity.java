package com.example.networkreconnaissance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText unameET, pwordET;
    Button loginBtn;
    FileOutputStream fostream;
    FileInputStream fistream;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unameET = (EditText) findViewById(R.id.eTxtUname);
        pwordET = (EditText) findViewById(R.id.eTxtPword);
        loginBtn = (Button) findViewById(R.id.btnSignIn);


        i = new Intent(MainActivity.this,DashboardActivity.class);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = unameET.getText().toString();
                String pword = pwordET.getText().toString();

                //Checks if the user credential file exists
                if(fileExist("user.txt")) {
                    //If yes, compare the entered credentials to the user.txt file
                    System.out.println("File exist! Compare entered credentials now.");

                    try {
                        //Will read the contents of user.txt file
                        fistream = openFileInput("user.txt");
                        StringBuffer sBuff = new StringBuffer();

                        int ctr;
                        while((ctr = fistream.read()) != -1) {
                            sBuff.append((char) ctr);
                        }
                        fistream.close();

                        String hold[] = sBuff.toString().split("\n");

                        //Compares the credential to login
                        if( (hold[0].equals(uname)) && (hold[1].equals(pword)) ){
                            //If credentials correct, login
                            System.out.println("Correct credentials! Signing-in...");
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Wrong Credentials! Try Again.", Toast.LENGTH_SHORT).show();
                        }
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
                }
                else {
                    //If no user credential exist, create user.txt file
                    System.out.println("File does not exist! Creating user.txt file");
                    String initUname = "admin\n";
                    String initPword = "scanner";


                    try {
                        fostream = openFileOutput("user.txt", Context.MODE_PRIVATE);

                        fostream.write(initUname.getBytes());
                        fostream.write(initPword.getBytes());
                        fostream.close();

                        System.out.println("File created!");
                        Toast.makeText(getApplicationContext(),"First-time sign-in process. Please click sign-in again.", Toast.LENGTH_LONG).show();
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
                }
            }
        });

    }

    public boolean fileExist(String userfile){
        System.out.println("Running fileExist method.");
        File file = getBaseContext().getFileStreamPath(userfile);
        return file.exists();
    }
}