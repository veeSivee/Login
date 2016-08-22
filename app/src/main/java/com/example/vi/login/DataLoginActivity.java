package com.example.vi.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataLoginActivity extends AppCompatActivity {

    @BindView(R.id.tvDataName) TextView tvDataName;
    @BindView(R.id.tvDataPhone) TextView tvDataPhone;
    @BindView(R.id.tvDataEmail) TextView tvDataEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_login);

        ButterKnife.bind(this);

        init();
    }

    private void init(){

        String name = getIntent().getStringExtra(getResources().getString(R.string.tag_name));
        String phone = getIntent().getStringExtra(getResources().getString(R.string.tag_phone));
        String email = getIntent().getStringExtra(getResources().getString(R.string.tag_email));

        tvDataName.setText(name);
        tvDataPhone.setText(phone);
        tvDataEmail.setText(email);
    }
}
