package com.example.asus.taskmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button bRegisterHere = (Button)findViewById(R.id.bRegisterHere);

        bRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        Button bLoginButton = findViewById(R.id.bLogin);

        bLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((EditText)findViewById(R.id.etEmail)).getText().toString();
                String password = ((EditText)findViewById(R.id.etPassword)).getText().toString();

                Log.d("EMAIL + PASSWORD", email + " " + password);
                FoneService.getToken(email, password, LoginActivity.this);
            }
        });
    }
}
