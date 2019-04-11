
package com.samluys.devdemo.day1106;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.samluys.devdemo.R;

public class LifecyclesActivity extends AppCompatActivity{

    LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);

        lifecycleRegistry = (LifecycleRegistry)getLifecycle();

        getLifecycle().addObserver(new MyObserver());


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LUYS", "onResume");
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }
}
