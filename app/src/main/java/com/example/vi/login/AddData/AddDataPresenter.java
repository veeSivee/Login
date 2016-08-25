package com.example.vi.login.adddata;

import com.example.vi.login.ValidasiData;

/**
 * Created by taufiqotulfaidah on 8/24/16.
 */
public class AddDataPresenter implements IAddDataPresenter {

    private IAddDataView view;
    ValidasiData validasiData;

    public AddDataPresenter(IAddDataView view){
        this.view = view;
        this.validasiData = new ValidasiData();
    }

    @Override
    public void clickSubmit(String name,String phone,String email) {

        boolean valName = validasiData.isDataNotNull(name);
        boolean valPhone = validasiData.isDataNotNull(phone);
        boolean valEmail = validasiData.isEmailValid(email);


        if(!valName){
            view.showErrorName();
        }else{
            view.noErrorName();
        }

        if(!valPhone){
            view.showErrorPhone();
        }else{
            view.noErrorPhone();
        }

        if(!valEmail){
            view.showErrorEmail();
        }else{
            view.noErrorEmail();
        }

        if(valName && valPhone && valEmail){
            view.addSharedPreference(name,phone,email);
            view.finishActivity();
        }

    }

    @Override
    public void clickBack() {
        //view.addSharedPreference(name,phone,email);
        view.finishActivity();
    }

    @Override
    public void textChange(String name,String phone,String email) {

        if(validasiData.isDataNotNull(name) &&
                validasiData.isDataNotNull(phone) &&
                validasiData.isDataNotNull(email) ){

            view.enableButton();
        }else{

            view.disableButton();
        }
    }


}
