package com.samluys.devdemo.http;

import android.accounts.NetworkErrorException;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;
import com.samluys.devdemo.ToastUtils;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.functions.Consumer;

/**
 * @author luys
 * @describe
 * @date 2019/4/15
 * @email ltym_lys@126.com
 */
public class ExceptionHandle implements Consumer<Throwable> {

    public ExceptionHandle() {

    }

    @Override
    public void accept(Throwable e) {
        try {
            String errMsg;
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                errMsg = "网络异常";
            } else if (e instanceof JsonSyntaxException) {
                errMsg = "JSON解析异常";
            } else {
                errMsg = "加载数据失败，请稍后再试";
            }

            ToastUtils.showShort(errMsg);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
