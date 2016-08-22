package com.example.vi.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher{

    @BindView(R.id.btnSubmit) Button btnSUbmit;
    @BindView(R.id.etFullname) EditText etName;
    @BindView(R.id.etPhone) EditText etPhone;
    @BindView(R.id.etEmail) EditText etEmail;
    @BindView(R.id.tlFullname) TextInputLayout tlFullname;
    @BindView(R.id.tlPhone) TextInputLayout tlPhone;
    @BindView(R.id.tlEmail) TextInputLayout tlEmail;

    ValidasiData validasiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init(){

        validasiData = new ValidasiData();

        btnSUbmit.setOnClickListener(this);
        etName.addTextChangedListener(this);
        etPhone.addTextChangedListener(this);
        etEmail.addTextChangedListener(this);

    }

    @Override
    public void onClick(View view) {

        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();

        boolean valName = validasiData.isDataNotNull(name);
        boolean valPhone = validasiData.isDataNotNull(phone);
        boolean valEmail = validasiData.isEmailValid(email);

        if(!valName){
            tlFullname.setError(getResources().getString(R.string.error_name));
        }else{
            tlFullname.setError(null);
        }

        if(!valPhone){
            tlPhone.setError(getResources().getString(R.string.error_phone));
        }else{
            tlPhone.setError(null);
        }

        if(!valEmail){
            tlEmail.setError(getResources().getString(R.string.error_email));
        }else{
            tlEmail.setError(null);
        }


        if(valName && valPhone && valEmail){
            Intent intent = new Intent(this,NavActivity.class);
            intent.putExtra(getResources().getString(R.string.tag_name),name);
            intent.putExtra(getResources().getString(R.string.tag_phone),phone);
            intent.putExtra(getResources().getString(R.string.tag_email),email);
            startActivity(intent);
        }

    }

    private void viewButton(){

        if(validasiData.isDataNotNull(etName.getText().toString()) &&
                validasiData.isDataNotNull(etPhone.getText().toString()) &&
                validasiData.isDataNotNull(etEmail.getText().toString()) ){
            btnSUbmit.setEnabled(true);
        }else{
            btnSUbmit.setEnabled(false);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        viewButton();
    }
}
