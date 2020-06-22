package com.example.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, pass;
    Button login , register;

    SharedPreferences prefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editText4);
        pass = (EditText)findViewById(R.id.editText5);
        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.Register);

        prefrences= getSharedPreferences("UserInfo",0);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = pass.getText().toString();

                String registeredUsername = prefrences.getString("username","");
                String registeredpassword = prefrences.getString("password","");

                if(usernameValue.equals(registeredUsername)&& passwordValue.equals(registeredpassword)){
                    Intent i = new Intent(MainActivity.this,Home.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });



    }
}
