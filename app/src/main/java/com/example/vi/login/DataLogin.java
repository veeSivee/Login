package com.example.vi.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataLogin extends AppCompatActivity {

    @BindView(R.id.tvDataName) TextView tvDataName;
    @BindView(R.id.tvDataPhone) TextView tvDataPhone;
    @BindView(R.id.tvDataEmail) TextView tvDataEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_login);

        ButterKnife.bind(this);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");

        tvDataName.setText(name);
        tvDataPhone.setText(phone);
        tvDataEmail.setText(email);

    }
}
