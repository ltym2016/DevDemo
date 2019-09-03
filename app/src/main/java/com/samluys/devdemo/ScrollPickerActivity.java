package com.samluys.devdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.samluys.devdemo.widgt.BitmapScrollPicker;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScrollPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_picker);

        final BitmapScrollPicker bitmapScrollPicker = findViewById(R.id.picker_02);

        final CopyOnWriteArrayList<Bitmap> bitmaps = new CopyOnWriteArrayList<Bitmap>();
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_header));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_header));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_header));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_header));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_header));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_header));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_header));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_default_portrait));

        bitmapScrollPicker.setData(bitmaps);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            Random mRandom = new Random();
            @Override
            public void onClick(View v){
                if (bitmapScrollPicker.isAutoScrolling()) {
                    return;
                }
                bitmapScrollPicker.autoScrollFast(bitmaps.size() + 1, 4000);
            }
        });
    }
}
