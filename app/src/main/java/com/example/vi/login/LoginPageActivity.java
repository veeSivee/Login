package com.example.vi.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginPageActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tl_username) TextInputLayout tl_username;
    @BindView(R.id.tl_password) TextInputLayout tl_password;
    @BindView(R.id.et_username) EditText et_username;
    @BindView(R.id.et_password) EditText et_password;
    @BindView(R.id.btn_login) Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);

        init();
    }

    private void init(){
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user = et_username.getText().toString();
        String pass = et_password.getText().toString();

        ValidasiData validasiData = new ValidasiData(this);

        if(validasiData.isAccountValid(user,pass)){
            tl_password.setError(null);

            Intent intent = new Intent(this,NavActivity.class);
            startActivity(intent);
            finish();
        }else{
            tl_password.setError(getResources().getString(R.string.error_not_valid_account));
        }
    }
}
