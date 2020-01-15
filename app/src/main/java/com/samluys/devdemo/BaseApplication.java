package com.samluys.devdemo;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;


/**
 * @author luys
 * @describe
 * @date 2019-07-14
 * @email samluys@foxmail.com
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        //内存泄漏检测
//        if (!LeakCanary.isInAnalyzerProcess(this)) {
//            LeakCanary.install(this);
//        }

        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(false)
                .setResizeAndRotateEnabledForNetwork(false)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .build();


        Fresco.initialize(this, imagePipelineConfig);
    }

    private static OkHttpClient getFrescoOkHttpClient() {
        X509TrustManager x509TrustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                //因为只是用于图片加载，所以信任所有证书，防止部分图片无法加载
                //方法不能为空，否则安全评估会有中度风险
                if (!TextUtils.isEmpty(authType)) {

                }
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }
        };
        final TrustManager[] trustAllCerts = new TrustManager[]{
                x509TrustManager
        };

        // Install the all-trusting trust manager
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // Create an ssl socket factory with our all-trusting manager
        if (sslContext != null) {
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory, x509TrustManager)
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    })
                    .build();
            return okHttpClient;
        } else {
            return new OkHttpClient();
        }
    }
}
