package com.example.vi.login.adddata;

/**
 * Created by taufiqotulfaidah on 8/24/16.
 */
public interface IAddDataView {
    void finishActivity();
    void addSharedPreference(String name,String phone,String email);
    void enableButton();
    void disableButton();
    void showErrorName();
    void showErrorPhone();
    void showErrorEmail();
    void noErrorName();
    void noErrorPhone();
    void noErrorEmail();

}
