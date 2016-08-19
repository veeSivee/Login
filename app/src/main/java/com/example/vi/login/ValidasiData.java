package com.example.vi.login;

import android.widget.EditText;

/**
 * Created by taufiqotulfaidah on 8/19/16.
 */
public class ValidasiData {

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
}
