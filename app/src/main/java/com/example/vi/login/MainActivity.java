package com.example.vi.login;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vi.login.AddData.AddDataPresenter;
import com.example.vi.login.AddData.IAddDataView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher, IAddDataView {

    @BindView(R.id.btnSubmit)
    Button btnSUbmit;

    @BindView(R.id.etFullname)
    EditText etName;

    @BindView(R.id.etPhone)
    EditText etPhone;

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.tlFullname)
    TextInputLayout tlFullname;

    @BindView(R.id.tlPhone)
    TextInputLayout tlPhone;

    @BindView(R.id.tlEmail)
    TextInputLayout tlEmail;

    private AddDataPresenter mPresenter;
    private String name,phone,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        init();
    }

    private void init(){

        mPresenter = new AddDataPresenter(this);

        btnSUbmit.setOnClickListener(this);
        etName.addTextChangedListener(this);
        etPhone.addTextChangedListener(this);
        etEmail.addTextChangedListener(this);

    }

    private void readInputData(){
        name = etName.getText().toString();
        phone = etPhone.getText().toString();
        email = etEmail.getText().toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        readInputData();
        mPresenter.clickSubmit(name,phone,email);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        readInputData();
        mPresenter.textChange(name,phone,email);
    }

    @Override
    public void onBackPressed() {

        mPresenter.clickBack();

        super.onBackPressed();
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void addSharedPreference(String name,String phone,String email) {
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.prefer_name), Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(getResources().getString(R.string.tag_name),name);
        edit.putString(getResources().getString(R.string.tag_phone),phone);
        edit.putString(getResources().getString(R.string.tag_email),email);
        edit.commit();
    }

    @Override
    public void enableButton() {
        btnSUbmit.setEnabled(true);
    }

    @Override
    public void disableButton() {
        btnSUbmit.setEnabled(false);
    }

    @Override
    public void showErrorName() {
        tlFullname.setError(getResources().getString(R.string.error_name));
    }

    @Override
    public void showErrorPhone() {
        tlPhone.setError(getResources().getString(R.string.error_phone));
    }

    @Override
    public void showErrorEmail() {
        tlEmail.setError(getResources().getString(R.string.error_email));
    }

    @Override
    public void noErrorName() {
        tlFullname.setError(null);
    }

    @Override
    public void noErrorPhone() {
        tlPhone.setError(null);
    }

    @Override
    public void noErrorEmail() {
        tlEmail.setError(null);
    }
}
