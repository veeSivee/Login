package com.example.vi.login.adddata;

/**
 * Created by taufiqotulfaidah on 8/24/16.
 */
public interface IAddDataPresenter {
    void clickSubmit(String name,String phone,String email);
    void clickBack();
    void textChange(String name,String phone,String email);
}
