package com.samluys.devdemo.androidQ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.samluys.devdemo.R;

import java.io.File;
import java.io.IOException;

public class AndroidQActivity extends AppCompatActivity {

    private static final String TAG = AndroidQActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_q);

        // /storage/emulated/0/Android/data/com.samluys.devdemo/files/Pictures
        File file = getExternalFilesDir("qq");
        Log.e(TAG, file.getPath());

        Log.e(TAG, "getExternalStorageState" + Environment.getExternalStorageState());

        String outputDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()
                + File.separator + "caiyu_chat2" + File.separator + "temp";
        Log.e(TAG, outputDir);
        createNoMediaFile(outputDir);

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.sun.action.test");
                intent.addCategory("com.sun.category.test");
//                intent.setDataAndType(Uri.parse("sunscheme://sun_host:8888/sunPath"), "sun_mimetype");
                startActivity(intent);
            }
        });

    }

    public void createNoMediaFile(String folderPath) {

        File folder = new File(folderPath);
        if (!folder.exists()) {
            try {
                folder.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        File file = new File(folderPath + File.separator + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
