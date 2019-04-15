package com.samluys.devdemo.rx;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.samluys.devdemo.R;

import java.util.List;

public class NetWorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
    }

    @SuppressLint("CheckResult")
    public void map(View view) {
//        Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUser/{userId}")
//                .addPathParameter("userId", "1")
//                .build()
//                .getObjectObservable(ApiUser.class)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<ApiUser, User>() {
//                    @Override
//                    public User apply(ApiUser apiUser) throws Exception {
//                        User user = new User();
//                        user.firstname = apiUser.firstname;
//                        user.id = apiUser.id;
//                        user.lastname = apiUser.lastname;
//
//                        return user;
//                    }
//                }).subscribe(new Consumer<User>() {
//            @Override
//            public void accept(User user) throws Exception {
//                Log.e("map", "user : " + user.toString());
//            }
//        });

    }

    public void zip(View view) {

    }

    public void flatMapAndFilter(View view) {

    }

//    private Observable<List<User>> getAllMyFriendsObservable() {
//        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFriends/{userId}")
//                .addPathParameter("userId", "1")
//                .build()
//                .getObjectListObservable(User.class);
//    }

    public void take(View view) {

    }

    public void flatMap(View view) {

    }

    public void flatMapWithZip(View view) {

    }
}
