package com.samluys.devdemo.color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.samluys.devdemo.R;

import java.util.Locale;

public class ColorDemoActivity extends AppCompatActivity {

    LinearLayout ll_background;
    TextView tv_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_demo);

        ll_background = findViewById(R.id.ll_background);
        tv_color = findViewById(R.id.tv_color);
        SeekBar sb_bar = findViewById(R.id.sb_bar);
        SeekBar sb_bar1 = findViewById(R.id.sb_bar1);
        sb_bar1.setMax(100);
        SeekBar sb_bar2 = findViewById(R.id.sb_bar2);
        sb_bar2.setMax(100);
        final CircleColorView cc_color = findViewById(R.id.cc_color);
        sb_bar.setMax(360);

        sb_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                cc_color.setHSVColor(progress, 100,100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_bar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                cc_color.setHSVColor(0,progress,100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_bar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                cc_color.setHSVColor(0,100,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        cc_color.setOnSeekColorListener(new CircleColorView.OnSeekColorListener() {
            @Override
            public void onSeekColorListener(int color) {
                ll_background.setBackgroundColor(color);
                tv_color.setText(getHexCode(color));
            }
        });

        Gson gson = new Gson();
        String str = gson.toJson(new ColorEntity(123, "red"));

        Log.e("Gson", "Gson" + str);

    }

    private String getHexCode(int color) {
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        return String.format(Locale.getDefault(), "%02X%02X%02X", r, g, b);
    }
}
