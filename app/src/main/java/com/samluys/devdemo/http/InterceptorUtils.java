package com.samluys.devdemo.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author luys
 * @describe 拦截器
 * @date 2018/4/23
 * @email samluys@foxmail.com
 */
public class InterceptorUtils {

    public static String TAG = "----";

    /**
     * 头部信息
     *
     * @return
     */
    public static Interceptor HeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request mRequest = chain.request().newBuilder()
                        .header("HJ-SYSTEM","2")
                        .header("HJ-IMEI", "")
                        .header("HJ-VERSION", "")
                        .build();
                return chain.proceed(mRequest);
            }
        };

    }

    /**
     * 日志拦截器
     *
     * @return
     */
    public static HttpLoggingInterceptor LogInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                LogUtils.json(message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
    }


}
