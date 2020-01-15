package com.samluys.devdemo;

import android.annotation.SuppressLint;
import android.app.AppComponentFactory;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.samluys.devdemo.androidQ.AndroidQActivity;
import com.samluys.devdemo.base.BaseActivity;
import com.samluys.devdemo.design.observer.EventBusActivity;
import com.samluys.devdemo.design.observer.TestCallbackActivity;
import com.samluys.devdemo.jetpack.viewmodel.ViewModelActivity;
import com.samluys.devdemo.rx.RxDemoActivity;
import com.samluys.devdemo.widgt.ReplyViewDialog;
import com.samluys.tablib.QFTabEntity;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import me.kareluo.intensify.image.IntensifyImage;
import me.kareluo.intensify.image.IntensifyImageView;

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

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
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

        final String url = "http://cartoon.chuji.mobi//uploads//20200102//a16158905cbccbfdfb6311f4f1e46f25.jpg";
        Uri uri = Uri.parse(url);

//        SimpleDraweeView sdv_image = findViewById(R.id.sdv_image);
//        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse("http://cartoon.chuji.mobi//uploads//20200102//a16158905cbccbfdfb6311f4f1e46f25.jpg"))
//                .setResizeOptions(new ResizeOptions(50, 50))
//                .build();
//
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setOldController(sdv_image.getController())
//                .setImageRequest(request)
//                .setAutoPlayAnimations(true)
//                .build();
//        sdv_image.setController(controller);

        final IntensifyImageView intensifyImage = findViewById(R.id.intensify_image);

        final SimpleDraweeView simpleDraweeView = findViewById(R.id.sdv_inage);
        simpleDraweeView.setImageURI(uri);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions(1280, 420))
                .build();

//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(uri)
//                .setImageRequest(request)
//                .setControllerListener(new BaseControllerListener<ImageInfo>() {
//                    @Override
//                    public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable anim) {
//                        if (imageInfo == null) {
//                            return;
//                        }
//                        int height = imageInfo.getHeight();
//                        int width = imageInfo.getWidth();
//
//                        Log.e("LUYS", height + " " + width);
//
//                        QualityInfo qualityInfo = imageInfo.getQualityInfo();
//                        Log.e("LUYS", "Final image received! " +
//                                        "Size %d x %d"+
//                                "Quality level %d, good enough: %s, full quality: %s"+
//                                imageInfo.getWidth()+" " +
//                                imageInfo.getHeight()+" " +
//                                qualityInfo.getQuality()+" " +
//                                qualityInfo.isOfGoodEnoughQuality()+" " +
//                                qualityInfo.isOfFullQuality());
//                    }
//
//                    @Override
//                    public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
//                        Log.d("TAG", "Intermediate image received");
//                    }
//
//                    @Override
//                    public void onFailure(String id, Throwable throwable) {
//                        throwable.printStackTrace();
//                    }
//                })
//                .setAutoPlayAnimations(true)
//                .build();
//        simpleDraweeView.setController(controller);

//        DataSubscriber dataSubscriber = new BaseDataSubscriber<CloseableReference<CloseableBitmap>>() {
//            @SuppressLint("ClickableViewAccessibility")
//            @Override
//            public void onNewResultImpl(
//                    DataSource<CloseableReference<CloseableBitmap>> dataSource) {
//                if (!dataSource.isFinished()) {
//                    return;
//                }
//                CloseableReference<CloseableBitmap> imageReference = dataSource.getResult();
//                if (imageReference != null) {
//                    final CloseableReference<CloseableBitmap> closeableReference = imageReference.clone();
//                    try {
//                        CloseableBitmap closeableBitmap = closeableReference.get();
//                        final Bitmap bitmap = closeableBitmap.getUnderlyingBitmap();
//                        if (bitmap != null && !bitmap.isRecycled()) {
//                            FileBinaryResource resource = (FileBinaryResource) Fresco.getImagePipelineFactory().
//                                    getMainFileCache().getResource(new SimpleCacheKey(url));
//                            if (resource != null) {
//                                final File file = resource.getFile();
//                                if (file.exists()) {
//                                    intensifyImage.setScaleType(IntensifyImage.ScaleType.FIT_AUTO);
//                                    intensifyImage.setOnScaleChangeListener(new IntensifyImage.OnScaleChangeListener() {
//                                        @Override
//                                        public void onScaleChange(float scale) {
//                                            Log.e("scale :" , scale + "");
//                                        }
//                                    });
//                                    intensifyImage.setOnTouchListener(new View.OnTouchListener() {
//                                        @Override
//                                        public boolean onTouch(View v, MotionEvent event) {
//                                            return false;
//                                        }
//                                    });
//                                    intensifyImage.post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            intensifyImage.setImage(file.getPath());
//                                            Log.e("path === > ", file.getPath());
//                                            try {
//
//
//                                                //获得图片的宽、高
//                                                BitmapFactory.Options tmpOptions = new BitmapFactory.Options();
//                                                tmpOptions.inJustDecodeBounds = true;
//                                                BitmapFactory.decodeFile(file.getPath(), tmpOptions);
//                                                int width = tmpOptions.outWidth;
//                                                int height = tmpOptions.outHeight;
//
//                                                //设置显示图片的中心区域
//                                                BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(file.getPath(), false);
//                                                BitmapFactory.Options options = new BitmapFactory.Options();
//                                                options.inPreferredConfig = Bitmap.Config.RGB_565;
//                                                Bitmap bitmap = bitmapRegionDecoder.decodeRegion(new Rect(0, 0, width, height), options);
//                                                simpleDraweeView.setImageBitmap(bitmap);
//
//                                            } catch (IOException e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                    });
//                                }
//                            }
//                        }
//                    } finally {
//                        imageReference.close();
//                        closeableReference.close();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailureImpl(DataSource dataSource) {
//                Throwable throwable = dataSource.getFailureCause();
//                // handle failure
//            }
//        };
//
//        getBitmap(this, uri, dataSubscriber);

        findViewById(R.id.btn_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EventBusActivity.class));
            }
        });


        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, AndroidQActivity.class));

                    ReplyViewDialog dialog = new ReplyViewDialog();

                dialog.showReplyView(getSupportFragmentManager());
            }
        });


        ZoomableDraweeView zoomableDraweeView = findViewById(R.id.zdv_image);
        DraweeController controller = Fresco.newDraweeControllerBuilder()//创建Fresco的图片下载配置
                .setUri(uri)
                .build();
        zoomableDraweeView.setController(controller);//将下载配置导入
    }

    /**
     * @param context
     * @param uri
     * @param dataSubscriber
     */
    public void getBitmap(Context context, Uri uri, DataSubscriber dataSubscriber) {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(uri);
        ImageRequest request = builder.build();
        DataSource<CloseableReference<CloseableImage>>
                dataSource = imagePipeline.fetchDecodedImage(request, context);
        dataSource.subscribe(dataSubscriber, Executors.newCachedThreadPool());
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
