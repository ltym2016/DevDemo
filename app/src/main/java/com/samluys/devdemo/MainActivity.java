package com.samluys.devdemo;

import android.app.AppComponentFactory;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.BitmapRegionDecoder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.samluys.devdemo.base.BaseActivity;
import com.samluys.devdemo.rx.RxDemoActivity;
import com.samluys.tablib.QFTabEntity;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

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
import androidx.fragment.app.FragmentManager;

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
    private ShortVideoDialog mShortDialog;
    private FragmentManager mManager;

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

        mManager = getSupportFragmentManager();

        findViewById(R.id.btn_rx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"修复------修复bug！",Toast.LENGTH_LONG).show();
//                TinkerInstaller.onReceiveUpgradePatch(getApplication().getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath()+"/patch.patch");

//                startActivity(new Intent(MainActivity.this, ScrollPickerActivity.class));
                mShortDialog = ShortVideoDialog.newInstance(1);
                mShortDialog.showDialog(getSupportFragmentManager(), "ShortVideoDialog");
            }
        });


        String json = "{'roomId':'(null)','type':'cancel','callType':'ssss'}";

        CallInfoEntity entity;
        try {
            entity = JSONObject.parseObject(json, CallInfoEntity.class);
        } catch (Exception e) {
            entity = null;
            Log.e("CallInfoEntity", "异常");
        }


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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mShortDialog = null;
    }
}
