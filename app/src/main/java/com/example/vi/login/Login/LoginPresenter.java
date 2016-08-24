package com.example.vi.login.Login;

import android.content.Context;
import android.content.Intent;

import com.example.vi.login.NavActivity;
import com.example.vi.login.R;
import com.example.vi.login.ValidasiData;

/**
 * Created by taufiqotulfaidah on 8/24/16.
 */
public class LoginPresenter implements ILoginPresenter{

    private ILoginView view;
    ValidasiData validasiData;

    public LoginPresenter(ILoginView view, Context context){
        this.view = view;
        this.validasiData = new ValidasiData(context);
    }

    @Override
    public void clickLogin(String name, String password) {
        if(validasiData.isAccountValid(name,password)){

            view.loginSuccess();
            view.saveDataLogin();
            view.openListDataActivity(name);
            view.finishActivity();
        }else{
            view.loginFailed();
        }
    }

    @Override
    public void start() {
        view.readDataLogin();
    }

    @Override
    public void checkLogin(String name, String password) {

        if(validasiData.isAccountValid(name,password)){

            view.loginSuccess();
            view.openListDataActivity(name);
            view.finishActivity();
        }
    }

}
