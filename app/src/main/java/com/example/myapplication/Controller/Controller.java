package com.example.myapplication.Controller;

import com.example.myapplication.Dao.Dao;
import com.example.myapplication.model.UserContainer;
import com.example.myapplication.utils.ResultListener;

public class Controller {

    private Dao dao;

    public Controller() {
        this.dao = new Dao();
    }

    public void getList (final ResultListener<UserContainer> listener){
        dao.getUserList(new ResultListener<UserContainer>() {
            @Override
            public void onFinish(UserContainer userContainer) {
                listener.onFinish(userContainer);
            }

        });
    }

    //public PeopleController(PeopleDAO.ShowError showError) {
    //        this.peopleDAO = new PeopleDAO();
    //        peopleDAO.setShowError(showError);
    //    }
    //
    //    public void getUserList(final ResultListener<Results> listener){
    //        peopleDAO.getUserList(new ResultListener<Results>() {
    //            @Override
    //            public void onFinish(Results result) {
    //                listener.onFinish(result);
    //            }
    //        });
    //    }

}
