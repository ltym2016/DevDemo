package com.samluys.devdemo.design.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.samluys.devdemo.R;

public class TestCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_callback);

        MomCallbackImpl impl = new MomCallbackImpl();
        impl.say(new XiaoMing(), "喊爸爸吃饭");
    }
}
