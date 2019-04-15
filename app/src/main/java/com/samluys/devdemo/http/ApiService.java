package com.samluys.devdemo.http;

import com.samluys.devdemo.rx.ApiUser;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author luys
 * @describe
 * @date 2019/4/15
 * @email ltym_lys@126.com
 */
public interface ApiService {

    @GET("getAnUser/{userId}")
    Observable<BaseResponse<ApiUser>> getApiUser(@Path("userId") String id);

}
