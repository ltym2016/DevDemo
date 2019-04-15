package com.samluys.devdemo.rx;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.samluys.devdemo.base.BaseViewModel;
import com.samluys.devdemo.http.BaseResponse;
import com.samluys.devdemo.http.ExceptionHandle;
import com.samluys.devdemo.http.RetrofitClientManager;
import com.samluys.devdemo.http.RxUtils;

import androidx.annotation.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author luys
 * @describe
 * @date 2019/4/12
 * @email samluys@foxmail.com
 */
public class RxDemoViewModel extends BaseViewModel {

    private Disposable disposable;


    public RxDemoViewModel(@NonNull Application application) {
        super(application);
    }

    public void onClick(View view) {

        getApiUser();
    }

    public void getApiUser () {
        addSubscribe(RetrofitClientManager.getInstance().getApiService().getApiUser("1")
                .compose(RxUtils.<BaseResponse<ApiUser>>iOThreadScheduler())
                .subscribe(new Consumer<BaseResponse<ApiUser>>() {
                    @Override
                    public void accept(BaseResponse<ApiUser> apiUserBaseResponse) throws Exception {

                    }
                }, new ExceptionHandle()));
    }
}
