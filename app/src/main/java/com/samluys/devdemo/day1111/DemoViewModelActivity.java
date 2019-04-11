package com.samluys.devdemo.day1111;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samluys.devdemo.R;

public class DemoViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_view_model);

        final MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        final TextView tv_model = findViewById(R.id.tv_model);
        tv_model.setText(myViewModel.textName);

        Button btn_modify = findViewById(R.id.btn_modify);
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.textName = "change = 22221";
                tv_model.setText(myViewModel.textName);
            }
        });
    }
}
