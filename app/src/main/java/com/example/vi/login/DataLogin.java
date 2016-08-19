package com.example.vi.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataLogin extends AppCompatActivity {

    TextView tvDataName, tvDataPhone, tvDataEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_login);

        tvDataName = (TextView)findViewById(R.id.tvDataName);
        tvDataPhone = (TextView)findViewById(R.id.tvDataPhone);
        tvDataEmail = (TextView)findViewById(R.id.tvDataEmail);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");

        tvDataName.setText(name);
        tvDataPhone.setText(phone);
        tvDataEmail.setText(email);

    }
}
