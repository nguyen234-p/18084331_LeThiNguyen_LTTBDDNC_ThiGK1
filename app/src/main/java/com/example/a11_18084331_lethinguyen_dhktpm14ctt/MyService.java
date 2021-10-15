package com.example.a11_18084331_lethinguyen_dhktpm14ctt;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private  MyBinder binder = new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public  int ADD(int a, int b){
        int result;
        result = a+b;
        return result;
    }
    public  int MUL(int a, int b){
        int result;
        result = a-b;
        return result;
    }
    public  double DIV(int a, int b){
        double result;
        result = a/b;
        return result;
    }
    public  int SUB(int a, int b){
        int result;
        result = a*b;
        return result;
    }
}
