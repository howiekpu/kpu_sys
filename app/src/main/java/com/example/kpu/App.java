package com.example.kpu;

import android.app.Application;

import com.example.kpu.bean.User;

public class App extends Application {

    private static User loginUser;

    public static void setLoginUser(User loginUser) {
        App.loginUser = loginUser;
    }

    public static User getLoginUser() {
        return loginUser;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
