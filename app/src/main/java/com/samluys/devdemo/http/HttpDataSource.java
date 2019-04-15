package com.samluys.devdemo.http;

import com.samluys.devdemo.rx.ApiUser;

import io.reactivex.Observable;


/**
 * @author luys
 * @describe
 * @date 2019/4/15
 * @email ltym_lys@126.com
 */
public interface HttpDataSource {

    Observable<ApiUser> getApiUser();
}
