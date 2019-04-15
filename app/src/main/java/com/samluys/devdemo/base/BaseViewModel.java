package com.samluys.devdemo.base;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import com.samluys.devdemo.rx.SingleLiveEvent;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author luys
 * @describe
 * @date 2019/4/12
 * @email samluys@foxmail.com
 */
public class BaseViewModel extends AndroidViewModel implements IBaseViewModel{

    private ViewLiveData mViewLiveData;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public ViewLiveData getViewLiveData() {
        if (mViewLiveData == null) {
            mViewLiveData = new ViewLiveData();
        }
        return mViewLiveData;
    }

    public void startActivity(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(ParameterField.CLASS, clz);
        if (bundle != null) {
            params.put(ParameterField.BUNDLE, bundle);
        }
        mViewLiveData.startActivityEvent.postValue(params);
    }


    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void registerRxBus() {

    }

    @Override
    public void removeRxBus() {

    }

    /**
     * View层的LiveData
     */
    public final class ViewLiveData extends SingleLiveEvent {

        private SingleLiveEvent<Map<String, Object>> startActivityEvent;
        private SingleLiveEvent<Void> finishEvent;
        private SingleLiveEvent<Void> onBackPressedEvent;

        public SingleLiveEvent<Map<String, Object>> getStartActivityEvent() {
            return startActivityEvent = createLiveData(startActivityEvent);
        }

        public SingleLiveEvent<Void> getFinishEvent() {
            return finishEvent = createLiveData(finishEvent);
        }

        public SingleLiveEvent<Void> getOnBackPressedEvent() {
            return onBackPressedEvent = createLiveData(onBackPressedEvent);
        }

        private SingleLiveEvent createLiveData(SingleLiveEvent liveData) {
            if (liveData == null) {
                liveData = new SingleLiveEvent();
            }
            return liveData;
        }

        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer observer) {
            super.observe(owner, observer);
        }
    }

    /**
     * 关闭界面
     */
    public void finish() {
        mViewLiveData.finishEvent.call();
    }

    /**
     * 返回上一层
     */
    public void onBackPressed() {
        mViewLiveData.onBackPressedEvent.call();
    }

    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String CANONICAL_NAME = "CANONICAL_NAME";
        public static String BUNDLE = "BUNDLE";
    }
}
