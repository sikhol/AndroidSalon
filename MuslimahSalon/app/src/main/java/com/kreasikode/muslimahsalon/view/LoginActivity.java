package com.kreasikode.muslimahsalon.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kreasikode.muslimahsalon.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                Intent loginIntent = new Intent(this, MenuActivity.class);
                startActivity(loginIntent);
        }
    }
}
