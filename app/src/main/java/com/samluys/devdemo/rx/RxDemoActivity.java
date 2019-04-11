package com.samluys.devdemo.rx;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.jakewharton.rxbinding3.view.RxView;
import com.samluys.devdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_demo);

        Button btn_binding = findViewById(R.id.btn_binding);
//        RxView.clicks(btn_binding).subscribe(new Consumer<Unit>() {
//            @Override
//            public void accept(Unit unit) throws Exception {
//                Log.e("RxJava_demo", "btn_binding");
//            }
//        });

        RxView.clicks(btn_binding).throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Unit>() {
                    @Override
                    public void accept(Unit unit) throws Exception {
                        Log.e("RxJava_demo", "btn_binding");
                    }
                });

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.add("a5");
        list.add("a6");

//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onCompleted() {
//            }
//
//            @Override
//            public void onError(Throwable e) {
//            }
//
//            @Override
//            public void onNext(String o) {
//            }
//        };
//
//        Subscriber subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.e("RxJava_demo", "完成");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("RxJava_demo", "异常");
//            }
//
//            @Override
//            public void onNext(String o) {
//
//                Log.e("RxJava_demo", "RxJava_demo" + o);
//            }
//        };
//
//        Observable.OnSubscribe<String> subscribe = new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("1");
//                subscriber.onNext("2");
//                subscriber.onNext("3");
//                subscriber.onNext("4");
//                subscriber.onCompleted();
//            }
//        };
//
//        Observable observable = Observable.create(subscribe);
//        Observable observable1 = Observable.just("just1","just2");
//
//        observable.subscribe(new Action1<String>() {
//            @Override
//            public void call(String o) {
//                Log.e("RxJava_demo", "Action1" + o);
//            }
//        });
//
//        Observable.from(list).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.e("RxJava_demo", "from" + s);
//            }
//        });

//        final ImageView iv_image = findViewById(R.id.iv_image);
//        Observable.create(new Observable.OnSubscribe<Drawable>() {
//            @Override
//            public void call(Subscriber<? super Drawable> subscriber) {
//                Drawable drawable = getTheme().getDrawable(R.drawable.ic_launcher_background);
//                subscriber.onNext(drawable);
//                subscriber.onCompleted();
//
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Drawable>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//                Toast.makeText(RxDemoActivity.this,"异常发生", Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onNext(Drawable drawable) {
//                iv_image.setImageDrawable(drawable);
//
//            }
//        });

//        Observable.just("2000")
//                .map(new Func1<String, Integer>() {
//                    @Override
//                    public Integer call(String s) {
//                        return Integer.valueOf(s);
//                    }
//                })
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer s) {
//                        Log.e("RxJava_demo", "map:" + (s+100));
//                    }
//                });
        List<Studuent> studuents = new ArrayList<>();
        Studuent studuent = new Studuent();
        studuent.setName("Zoe");
        List<Course> courses = new ArrayList<>();
        Course course = new Course();
        course.setName("Java");
        courses.add(course);
        course = new Course();
        course.setName("Java1");
        courses.add(course);
        course = new Course();
        course.setName("Java2");
        courses.add(course);
        studuent.setCourses(courses);
        studuents.add(studuent);

        studuent = new Studuent();
        studuent.setName("Zoe1");
        List<Course> courses1 = new ArrayList<>();
        Course course1 = new Course();
        course1.setName("Php");
        courses1.add(course1);
        course1 = new Course();
        course1.setName("Php1");
        courses1.add(course1);
        course1 = new Course();
        course1.setName("Php2");
        courses1.add(course1);
        studuent.setCourses(courses1);
        studuents.add(studuent);

        Observable.from(studuents)
                .map(new Func1<Studuent, String>() {
                    @Override
                    public String call(Studuent studuent) {
                        return studuent.getName();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("RxJava_demo", "map:" + s);
                    }
                });

        Observer<Course> observer = new Observer<Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                Log.e("RxJava_demo", "flatmap:" + course.getName());
            }
        };

        Observable.from(studuents)
                .flatMap(new Func1<Studuent, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Studuent studuent) {
                        return Observable.from(studuent.getCourses());
                    }
                }).subscribe(observer);

    }



}
