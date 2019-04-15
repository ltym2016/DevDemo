package com.samluys.devdemo.http;

import com.samluys.devdemo.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author luys
 * @describe
 * @date 2019/4/15
 * @email samluys@foxmail.com
 */
public class RetrofitClientManager {

    private static RetrofitClientManager instance;

    private RetrofitClientManager() {

    }

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

    public Retrofit getRetrofit(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new LogInterceptor());
        }
        OkHttpClient okHttpClient = builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
