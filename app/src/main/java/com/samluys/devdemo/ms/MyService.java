package com.samluys.devdemo.ms;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author luys
 * @describe
 * @date 2019/2/23
 * @email samluys@foxmail.com
 */
public class MyService extends Service {

    public class MyBinder extends Binder {

        public MyService getService() {
            return MyService.this;
        }
    }

    private IBinder binder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("MyService", "onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("MyService", "onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String nameTest = intent.getStringExtra("key_name_test");

        Log.e("MyService", "onStartCommand : " + nameTest);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("MyService", "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MyService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyService", "onBind");
        return binder;
    }
}
