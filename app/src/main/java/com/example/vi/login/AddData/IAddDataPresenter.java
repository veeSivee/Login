package com.example.vi.login.AddData;

/**
 * Created by taufiqotulfaidah on 8/24/16.
 */
public interface IAddDataPresenter {
    void clickSubmit(String name,String phone,String email);
    void clickBack(String name,String phone,String email);
    void textChange(String name,String phone,String email);
}
