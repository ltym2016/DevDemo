package com.samluys.devdemo.day1113;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samluys.devdemo.R;

public class NameActivity extends AppCompatActivity {
    private NameViewModel nameViewModel;
    private TextView et_input;
    private Button btn_click;
    private MutableLiveData<String> mLiveData;
    private int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        et_input = findViewById(R.id.et_input);
        btn_click = findViewById(R.id.btn_click);
        nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        Observer<Float> observer = new Observer<Float>() {
            @Override
            public void onChanged(Float newName) {
                et_input.setText(newName+"");
            }
        };
        mLiveData = nameViewModel.getCurrentName();

        MutableLiveData<Float> mutableLiveData = (MutableLiveData)Transformations.map(mLiveData, new Function<String, Float>() {
            @Override
            public Float apply(String input) {
                if (Float.valueOf(input) % 2 == 0) {
                    return Float.valueOf(input) + 10;
                } else {
                    return Float.valueOf(input) - 10;
                }

            }
        });

        mutableLiveData.observe(this, observer);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLiveData.setValue((n++)+"");

            }
        });
    }
}
