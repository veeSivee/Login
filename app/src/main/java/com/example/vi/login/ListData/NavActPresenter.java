package com.example.vi.login.ListData;

import com.example.vi.login.ListData.INavActPresenter;
import com.example.vi.login.ListData.INavActView;

/**
 * Created by taufiqotulfaidah on 8/23/16.
 */
public class NavActPresenter implements INavActPresenter {

    private INavActView view;

    public NavActPresenter(INavActView view){
        this.view = view;
    }

    @Override
    public void addNewData() {
        view.showNewData();
    }

    @Override
    public void insertData(String name){
        if(!name.isEmpty()){
            view.showNewData();
            view.clearData();
        }
    }

    @Override
    public void clickFabNav() {
        view.showAddDataActivity();
    }

    @Override
    public void clickLogout() {
        view.logOut();
    }
}
