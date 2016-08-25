package com.example.vi.login.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vi.login.R;
import com.example.vi.login.listdata.NavActivity;
import com.example.vi.login.login.ILoginView;
import com.example.vi.login.login.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginPageActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    @BindView(R.id.tl_username)
    TextInputLayout tl_username;

    @BindView(R.id.tl_password)
    TextInputLayout tl_password;

    @BindView(R.id.et_username)
    EditText et_username;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.btn_login)
    Button btn_login;

    private LoginPresenter mPresenter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);

        init();
    }

    private void init(){
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.prefer_login),Context.MODE_PRIVATE);
        mPresenter = new LoginPresenter(this,this);

        btn_login.setOnClickListener(this);

        mPresenter.start();
    }

    @Override
    public void onClick(View view) {
        String user = et_username.getText().toString();
        String pass = et_password.getText().toString();

        mPresenter.clickLogin(user,pass);
    }

    @Override
    public void loginSuccess() {
        tl_password.setError(null);
    }

    @Override
    public void loginFailed() {
        tl_password.setError(getResources().getString(R.string.error_not_valid_account));
    }

    @Override
    public void openListDataActivity(String user) {
        Intent intent = new Intent(this,NavActivity.class);
        intent.putExtra(getResources().getString(R.string.tag_name),user);
        startActivity(intent);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void saveDataLogin() {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(getResources().getString(R.string.tag_user),et_username.getText().toString());
        edit.putString(getResources().getString(R.string.tag_password),et_password.getText().toString());
        edit.commit();
    }

    @Override
    public void readDataLogin() {
        String user = sharedPreferences.getString(getResources().getString(R.string.tag_user),null);
        String pass = sharedPreferences.getString(getResources().getString(R.string.tag_password),null);

        /*if(pass==null){
            Log.i("cek login empty",user + " ~ " + pass);
        }else{
            Log.i("cek login adaaa",user + " ~ " + pass);
        }

        Log.i("cek login",user + " ~ " + pass);*/

        mPresenter.checkLogin(user,pass);
    }
}
