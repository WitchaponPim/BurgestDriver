package com.alongkod.burgestdriver.API;

import com.alongkod.burgestdriver.Callback.LoginCallback;
import com.alongkod.burgestdriver.Model.Driver;
import com.alongkod.burgestdriver.Utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectManager {
    public static final String BASE_URL = Utils.ipHost;

    //    private static Retrofit retrofit = null;
//    public static int unique_id;
//
//    public static Retrofit getClient() {
//        if (retrofit==null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
    public ConnectManager() {

    }


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    APIService con = retrofit.create(APIService.class);

    public void login(final LoginCallback listener, String user, String pass) {
        Call call = con.login(user, pass);
        call.enqueue(new Callback<Driver>() {
            @Override
            public void onResponse(Call<Driver> call, Response<Driver> response) {
                Driver user = response.body();
                if (user == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(user, retrofit);
                }
            }

            @Override
            public void onFailure(Call<Driver> call, Throwable t) {
                listener.onFailure(t);
            }

        });
    }


}
