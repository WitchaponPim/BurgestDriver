package com.alongkod.burgestdriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alongkod.burgestdriver.API.ConnectManager;
import com.alongkod.burgestdriver.Callback.LoginCallback;
import com.alongkod.burgestdriver.Model.Driver;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    EditText user, pass;
    ConnectManager connect = new ConnectManager();
    LoginCallback callback = new LoginCallback() {
        @Override
        public void onResponse(Driver driver, Retrofit retrofit) {
        Utils.toast(getApplicationContext(),driver.getCheckloginadmin().getDescription());
        startActivity(new Intent(LoginActivity.this,MainMenuActivity.class));
        }

        @Override
        public void onFailure(Throwable t) {

        }

        @Override
        public void onBodyError(ResponseBody responseBody) {

        }

        @Override
        public void onBodyErrorIsNull() {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
    }
    public void login(View view){
        String a,b;
        a = user.getText().toString();
        b = pass.getText().toString();
        connect.login(callback,a,b);
    }
}
