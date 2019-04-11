package com.samluys.devdemo;

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

import com.samluys.devdemo.color.ColorDemoActivity;
import com.samluys.devdemo.day0108.Day;
import com.samluys.devdemo.day0108.Day1;
import com.samluys.devdemo.day1121.User;
import com.samluys.devdemo.day1121.UserManager;
import com.samluys.devdemo.ms.MyService;
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

public class MainActivity extends BaseActivity {

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
    private MyService myService;

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

            myService = ((MyService.MyBinder)service).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_destory = findViewById(R.id.btn_destory);
        UserManager.sUserId = 2;
        Log.e("ZOE", "MainActivity sUerId:" + UserManager.sUserId);


        initData();

//        Log.e("LUYS_SUCCESS", TestEnum.SUCCESS.getDesc());
//        Log.e("LUYS_SUCCESS", TestEnum.SUCCESS.getValue());
//        Log.e("LUYS_SUCCESS", TestEnum.FAILED.ordinal()+"");
//        Log.e("LUYS_compareTo", TestEnum.SUCCESS.compareTo(TestEnum.FAILED) + "");
//        Log.e("LUYS_name", TestEnum.SUCCESS.name());
//        Log.e("LUYS_Values", Arrays.toString(TestEnum.values()));
//        Log.e("LUYS_ValueOf", TestEnum.valueOf("SUCCESS")+"");

//        for (Day d: Day.values()) {
//            Log.e("LUYS_DAY", d.name() + ":" + d.toString());
//        }

        for (Day1 d : Day1.values()) {
            Log.e("LUYS_DAY", d.name() + ":" + d.getInfo());
        }


        Map<Day, Integer> enumMap = new EnumMap<>(Day.class);

        final Random random = new Random(10);
        final Random random1 = new Random(10);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,SecondActivity.class));
//                startActivity(new Intent(MainActivity.this,DemoViewModelActivity.class));

//                startActivity(new Intent(MainActivity.this,SecondActivity.class));
//                startActivity(new Intent(MainActivity.this,NameActivity.class));
//                Intent intent = new Intent();
//                intent.setAction("com.samluys.testaction");
//                intent.addCategory("com.samluys.testcategory");
//                intent.setDataAndType(Uri.parse("samluys://www.zoe.com"), "image/*");

//                startActivity(intent);
//                Intent intent = new Intent(MainActivity.this,GestureDemoActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putInt("11",1);
//                intent.putExtra("BUNDLE_TEST", bundle);
//
//                MainActivity.this.getApplicationContext().startActivity(intent,bundle);

//                Log.e("LUYS", random.nextInt(100) + ":" + random1.nextInt(100));

//                testAssert(-1);
                Intent intent = new Intent(MainActivity.this, ColorDemoActivity.class);
//                intent.putExtra("key_name_test", "hhahahahh");
                startActivity(intent);

//                startService(intent);
//
//                bindService(intent, mConn, Context.BIND_AUTO_CREATE);
            }
        });

        btn_destory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mConn);
            }
        });


        User user = new User(112, "Zoe");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cache.txt"));
            out.writeObject(user);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cache.txt"));
            User newUser = (User) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        aboutJavaWeiyi();


//        final LinesEditView et_input = findViewById(R.id.et_input);
//        et_input.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.e("LUYS-content-b", s.toString());
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                String content = s.toString();
//                if(content.length() % 4 == 0) {
//                    content = content + "换行";
//                }
//
//                Log.e("LUYS-content", content);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.e("LUYS-content-a", s.toString());
//            }
//        });

//        final ImageView iv_animator = findViewById(R.id.iv_animator);
////        ValueAnimator valueAnimator = (ValueAnimator)AnimatorInflater.loadAnimator(this,R.animator.value_animator);
////        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
////            @Override
////            public void onAnimationUpdate(ValueAnimator animation) {
////                iv_animator.setY((float) animation.getAnimatedValue());
//////                iv_animator.setBackgroundColor((int) ( (float)animation.getAnimatedValue()));
////            }
////        });
////        valueAnimator.start();
//
//        AnimatorSet valueAnimator = (AnimatorSet)AnimatorInflater.loadAnimator(this,R.animator.set_animator);
//        valueAnimator.setTarget(iv_animator);
//        valueAnimator.start();

//        for (int i = 0; i < mTitles.length; i++) {
//            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
//        }
//
//        // 默认5栏
//
////        QFBottomTabLayout tab = findViewById(R.id.tab);
//        tab.setTabData(mTabEntities);
//
//
//        findViewById(R.id.btn_mvvm).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//            }
//        });

        findViewById(R.id.btn_rx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RxDemoActivity.class));
            }
        });

    }

    private void aboutJavaWeiyi() {
//        int number = 10;
//        int number2 = 10;
//        Log.e("LUYS","十进制：" + Integer.toBinaryString(number) + " 原始数：" + number);
//        number = number << 2;
//        Log.e("LUYS","左移一位：" + Integer.toBinaryString(number) + " 原始数：" + number);
//
//        number2 = number2 >> 2;
//        Log.e("LUYS","右移一位：" + Integer.toBinaryString(number2) + " 原始数：" + number2);
        String a = Integer.toBinaryString(4);
        String b = Integer.toBinaryString(7);
        Log.e("LUYS","按位异或：" + b);


    }

    private void initData() {
        int touchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        Log.e("ZOE", "touchSlop:" + touchSlop);

        Executors.newFixedThreadPool(2);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(1);
        Executors.newSingleThreadExecutor();


        int a = sort();


//        for (int i = 0, j = i + 10; i < 5; i++, j = i*2) {
//
//            Log.e("ZOE_LUYS", "i : " + i + " j :" + j);
//        }

        // break 在多重循环下的终止流程

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                Log.e("ZOE_LUYS", "j : " + j);
                if (j == 2) {
                    break;
                }
            }

            Log.e("ZOE_LUYS", "i====== : " + i);
        }
    }

    public void testSwitch(Day day) {
        switch (day) {
            case MONDAY:
                break;
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

}
