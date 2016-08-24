package com.example.vi.login;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by taufiqotulfaidah on 8/19/16.
 */
public class ValidasiData {

    Context context;

    public ValidasiData(){}

    public ValidasiData(Context context){
        this.context = context;
    }

    public boolean isDataNotNull(String name){
        boolean cek = true;

        if(name.equals("")){
            cek = false;
        }

        return cek;
    }

    public boolean isEmailValid(String email){
        boolean cek = true;

        if(email.equals("")){
            cek = false;
        }else{
            cek = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        return cek;
    }

    public boolean isAccountValid(String username,String pass){

        if(pass.toUpperCase().equals(context.getResources().getString(R.string.pass_valid))){
            return true;
        }else{
            return false;
        }
    }

}
