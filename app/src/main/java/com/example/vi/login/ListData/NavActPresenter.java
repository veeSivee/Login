package com.example.vi.login.listdata;

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

        if(name==null || name.isEmpty()){

        }else{
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
        view.clearDataUser();
        view.logOut();
    }
}
