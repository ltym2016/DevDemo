package com.samluys.devdemo.http;

import android.os.Build;

/**
 * @author luys
 * @describe 网络请求相关配置
 * @date 2018/4/23
 * @email samluys@foxmail.com
 */
public class HttpConfig {

    /**
     * HOST
     */
    public static final String HTTP_URL = "https://fierce-cove-29863.herokuapp.com";

    /**
     * 请求时长
     */
    public static final long HTTP_TIME = 30;

    /**
     * 请求成功状态
     */
    public static final String SUCCESS = "success";

    /**
     * 请求失败状态
     */
    public static final String ERROR = "error";

    /**
     * UserAgent
     */
    public static final String USERAGENT = ("QianFanEsf;" + "Const.APP_NAME" + ";"
            + "Android;Mozilla/5.0;AppleWebkit/533.1;" +
            Build.MODEL + Build.BRAND + Build.VERSION.SDK_INT + ";").replace(" ", "");;

}
