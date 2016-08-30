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
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;

public class LoginPageActivity extends AppCompatActivity implements ILoginView {

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

    Subscription subUser, subPass, subLogin;

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

        //btn_login.setOnClickListener(this);

        tl_username.setError(getResources().getString(R.string.error_not_valid_user));
        subUser = RxTextView.textChanges(et_username)
                .map(inputUser->(inputUser.length() == 0) || (inputUser.length() >= 5))
                .subscribe(isValid->setErrorUser(!isValid));

        tl_password.setError(getResources().getString(R.string.error_not_valid_password));
        subPass = RxTextView.textChanges(et_password)
                .map(inputPass->(inputPass.length()==0) || (inputPass.toString().toUpperCase().matches(getResources().getString(R.string.pass_valid))))
                .subscribe(isValidp->setErrorPassword(!isValidp));

        subLogin = RxView.clicks(btn_login).subscribe(aVoid -> clickLoginButton());

        mPresenter.start();
    }

    private void setErrorUser(Boolean bool){
        if(bool){
            tl_username.getChildAt(1).setVisibility(View.VISIBLE);
        }else{
            tl_username.getChildAt(1).setVisibility(View.GONE);
        }
    }

    private void setErrorPassword(Boolean bool){
        if(bool){
            tl_password.getChildAt(1).setVisibility(View.VISIBLE);
        }else{
            tl_password.getChildAt(1).setVisibility(View.GONE);
        }
    }

    private void clickLoginButton(){
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

        mPresenter.checkLogin(user,pass);
    }
}
