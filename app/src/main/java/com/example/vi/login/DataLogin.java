package com.example.vi.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DataLogin extends AppCompatActivity {

    @InjectView(R.id.tvDataName) TextView tvDataName;
    @InjectView(R.id.tvDataPhone) TextView tvDataPhone;
    @InjectView(R.id.tvDataEmail) TextView tvDataEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_login);

        ButterKnife.inject(this);

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
