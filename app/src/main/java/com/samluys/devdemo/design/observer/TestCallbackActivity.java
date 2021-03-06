package com.samluys.devdemo.design.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.samluys.devdemo.R;

public class TestCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_callback);

//        MomCallbackImpl impl = new MomCallbackImpl();
//        impl.say(new XiaoMing(), "喊爸爸吃饭");

        // 观察者模式--公众号订阅的例子
//        IWxServerSubject iWxServerSubject = new TigerChainSubject() ;
//
//        ReaderObserver zhangsai = new ReaderObserver("张三") ;
//        ReaderObserver lisi = new ReaderObserver("李四") ;
//        ReaderObserver wangwu = new ReaderObserver("王五") ;
//        ReaderObserver zhaoLiu = new ReaderObserver("赵六") ;
//
//        iWxServerSubject.attachObserver(zhangsai);
//        iWxServerSubject.attachObserver(lisi);
//        iWxServerSubject.attachObserver(wangwu);
//        iWxServerSubject.attachObserver(zhaoLiu);

//        ((TigerChainSubject)iWxServerSubject).submitContent("一个好人");

        // 狼王下达命令例子
        ZhenChaLang zhenChaLang = new ZhenChaLang(LangWang.getInstance());
        LieShaLang lieShaLang = new LieShaLang(LangWang.getInstance());

        LangWang.getInstance().publishCommand("开始行动");

    }
}
