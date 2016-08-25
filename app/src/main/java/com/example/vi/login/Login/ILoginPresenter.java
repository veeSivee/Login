package com.example.vi.login.login;

/**
 * Created by taufiqotulfaidah on 8/24/16.
 */
public interface ILoginPresenter {
    void clickLogin(String name,String password);
    void start();
    void checkLogin(String name,String password);
}
