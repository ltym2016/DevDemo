package com.samluys.devdemo.capter3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.samluys.devdemo.R;
import com.samluys.devdemo.other.DynamicUtils;

public class ScrollActivity extends AppCompatActivity {


    private String dynamicName;

    private String testName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        Log.e("ZOE", "注解Value : " + dynamicName);

        RecyclerView rv_content1 = findViewById(R.id.rv_content1);
        RecyclerView rv_content2 = findViewById(R.id.rv_content2);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        rv_content1.setLayoutManager(linearLayoutManager1);
        rv_content2.setLayoutManager(linearLayoutManager2);


        rv_content1.setAdapter(new ScrollAdapter(this));
        rv_content2.setAdapter(new ScrollAdapter(this));

    }
}
