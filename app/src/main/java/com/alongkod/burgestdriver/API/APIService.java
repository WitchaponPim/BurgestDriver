package com.alongkod.burgestdriver.API;

import com.alongkod.burgestdriver.Model.Driver;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ptwitchapon on 21/6/2561.
 */

public interface APIService {

    //checkadminlogin.php
    @FormUrlEncoded
    @POST("checkadminlogin.php")
    Call<Driver> login(@Field("username") String user,@Field("password") String password);
}
