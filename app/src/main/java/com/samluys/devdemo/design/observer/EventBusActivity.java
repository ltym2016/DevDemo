package com.samluys.devdemo.design.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.samluys.devdemo.R;

public class EventBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        CustomEventBus.getInstance().register(this);

        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomEventBus.getInstance().post("点击");
            }
        });
    }

    public void onEvent(String string) {
        Log.e("onEvent", string);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        CustomEventBus.getInstance().unRegister(this);
    }
}
