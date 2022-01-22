package com.procohat.testproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {
    Button login;
    TextView noacc;
    TextInputEditText edtuser,edtpass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.btnLogin);
        noacc = findViewById(R.id.noacc);
        edtuser= findViewById(R.id.edtuser);
        edtpass=findViewById(R.id.edtpass);
        btnLogin=findViewById(R.id.btnLogin);
        noacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (edtuser.getText().toString().equals("test@gmail.com") && edtpass.getText().toString().equals("1234")) {
                    Intent intent = new Intent(MainActivity.this, welcome.class);
                    startActivity(intent);
                    if (edtuser.getText().toString().trim().length() == 0) {
                        edtuser.setError("Username is not entered!");
                        edtuser.requestFocus();
                    } else if (edtpass.getText().toString().trim().length() >5) {
                        edtpass.setError("Password is not entered!");
                        edtpass.requestFocus();
                    }
                } else {
                    edtuser.setError("Invalid Username!");
                    edtpass.setError("Invalid Password!");
                }


                /*else {
                    Intent intent = new Intent(MainActivity.this, welcome.class);
                    startActivity(intent);
                }*/
            }
        });
    }
}