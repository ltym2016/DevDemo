package com.samluys.devdemo;

import android.app.AppComponentFactory;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.BitmapRegionDecoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;

import com.samluys.devdemo.base.BaseActivity;
import com.samluys.devdemo.rx.RxDemoActivity;
import com.samluys.tablib.QFTabEntity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private Button btn_start;
    private Button btn_destory;
    private Handler handler;
    private SharedPreferences sharePreferences;
    private ThreadPoolExecutor threadPoolExecutor;
    private Service service;
    private BitmapRegionDecoder decoder;
    private Boolean aBoolean;
    private BigInteger bigInteger;
    private int a;

    private ArrayList<QFTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles = {"首页", "社区", "本地圈", "消息", "发现"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab1, R.mipmap.tab2,
            R.mipmap.tab3, R.mipmap.tab4, R.mipmap.tab5};
    private int[] mIconSelectIds = {
            R.mipmap.tab1_selected, R.mipmap.tab2_selected,
            R.mipmap.tab3_selected, R.mipmap.tab4_selected, R.mipmap.tab5_selected};

    private int[] mCoverImageIds = {
            0, R.mipmap.icon_cover,
            0, R.mipmap.icon_cover1, 0};

    private HashMap<String, List<String>> hashMap = new HashMap<>();

    private ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.btn_rx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RxDemoActivity.class));
            }
        });

    }


    private void testAssert(int a) {
        assert a > 0;
        Log.e("LUYS", "SUCCESS");
    }


    int[] arrys = {1,22,3,55,23,44};

    private int sort() {
        for (int i = 0; i < arrys.length - 1; i++) {
            for (int j = 0; j < arrys.length - 1 -i; j++) {
                if (arrys[j] >arrys[j+1] ) {
                    int temp = arrys[j];
                    arrys[j] = arrys[j+1];
                    arrys[j+1] = temp;

                    if (j == 3) {
                        a = 10;
                    }
                }
            }
        }

        return arrys.length + 1;
    }

}
