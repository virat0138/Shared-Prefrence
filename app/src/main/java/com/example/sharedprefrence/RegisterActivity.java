package com.example.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, dob, country, email, address, phone;
    RadioGroup gender;
    Button register, cancel;

    SharedPreferences prefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.UserName);
        password = (EditText) findViewById(R.id.Password);
        dob = (EditText) findViewById(R.id.dob);
        country = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.EMAIL);
        address = (EditText) findViewById(R.id.Address);
        phone = (EditText) findViewById(R.id.Phone);
        gender= (RadioGroup)findViewById(R.id.gender);
        register = (Button)findViewById(R.id.REGISTER);
        cancel = (Button)findViewById(R.id.CANCEL);

        prefrences= getSharedPreferences("UserInfo",0);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String dobValue = dob.getText().toString();
                String countryValue = country.getText().toString();
                String emailValue = email.getText().toString();
                String addressValue = address.getText().toString();
                String phoneValue = phone.getText().toString();
                RadioButton check = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = check.getText().toString();

                if(usernameValue.length()>1) {
                    SharedPreferences.Editor editor = prefrences.edit();
                    editor.putString("Username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("dob", dobValue);
                    editor.putString("Country", countryValue);
                    editor.putString("email", emailValue);
                    editor.putString("address", addressValue);
                    editor.putString("Phone", phoneValue);
                    editor.putString("gender", genderValue);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Enter Values in the Fields", Toast.LENGTH_SHORT).show();
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void empty(){
        username.setText("");
        password.setText("");
        dob.setText("");
        email.setText("");
        address.setText("");
        country.setText("");
        phone.setText("");
    }
}
