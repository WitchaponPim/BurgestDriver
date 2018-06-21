package com.alongkod.burgestdriver.Callback;

import com.alongkod.burgestdriver.Model.Driver;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by ptwitchapon on 21/6/2561.
 */

public interface LoginCallback {
    public void onResponse(Driver driver, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
