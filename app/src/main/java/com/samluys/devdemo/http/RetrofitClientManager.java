package com.samluys.devdemo.http;

import com.samluys.devdemo.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author luys
 * @describe
 * @date 2019/4/15
 * @email samluys@foxmail.com
 */
public class RetrofitClientManager {

    private static RetrofitClientManager instance;
    private static ApiService mApiService;

    public static RetrofitClientManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitClientManager.class) {
                if (instance == null) {
                    instance = new RetrofitClientManager();
                }
            }
        }
        return instance;
    }

    private RetrofitClientManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .writeTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .readTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtils.HeaderInterceptor());

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(InterceptorUtils.LogInterceptor());
        }
        OkHttpClient okHttpClient = builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.HTTP_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mApiService = retrofit.create(ApiService.class);
    }



    public ApiService getApiService() {
        return mApiService;
    }
}
