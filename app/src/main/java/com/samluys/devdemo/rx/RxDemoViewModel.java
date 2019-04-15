package com.samluys.devdemo.rx;

import android.app.Application;
import android.view.View;

import com.samluys.devdemo.base.BaseViewModel;
import com.samluys.devdemo.http.ApiService;
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
        disposable = RetrofitClientManager.getInstance().getRetrofit("https://fierce-cove-29863.herokuapp.com/")
                .create(ApiService.class).getApiUser("1")
                .compose(RxUtils.<ApiUser>iOThreadScheduler())
                .compose(RxUtils.exceptionTransformer())
                .subscribe(new Consumer<ApiUser>() {
                    @Override
                    public void accept(ApiUser apiUser) throws Exception {
                        String name = apiUser.firstname;
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
