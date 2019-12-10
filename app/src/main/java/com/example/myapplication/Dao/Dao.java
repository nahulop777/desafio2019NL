package com.example.myapplication.Dao;

import com.example.myapplication.model.UserContainer;
import com.example.myapplication.service.ServiceUser;
import com.example.myapplication.utils.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dao {

    public static final String BASE_URL = "https://randomuser.me/";
    private Retrofit retrofit;
    private ServiceUser serviceUser;


    public Dao(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        serviceUser = retrofit.create(ServiceUser.class);
    }

    public void getUserList(final ResultListener<UserContainer> listener) {

        Call<UserContainer> resultsCall = serviceUser.getResults(20);

        resultsCall.enqueue(new Callback<UserContainer>() {
            @Override
            public void onResponse(Call<UserContainer> call, Response<UserContainer> response) {
                if (response.isSuccessful()) {
                    UserContainer userContainer = response.body();
                    System.out.println("Cargo correctamente");

                    listener.onFinish(userContainer);
                } else System.out.println("La carga fallo");
            }

            @Override
            public void onFailure(Call<UserContainer> call, Throwable t) {

                String message = t.getMessage();
                System.out.println("La carga fallo");

            }
        });
    }
}
