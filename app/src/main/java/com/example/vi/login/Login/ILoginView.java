package com.example.vi.login.login;

/**
 * Created by taufiqotulfaidah on 8/24/16.
 */
public interface ILoginView {
    void loginSuccess();
    void loginFailed();
    void openListDataActivity(String user);
    void finishActivity();
    void saveDataLogin();
    void readDataLogin();
}
