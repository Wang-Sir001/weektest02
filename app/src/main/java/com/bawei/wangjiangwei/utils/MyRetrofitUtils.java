package com.bawei.wangjiangwei.utils;

import com.bawei.wangjiangwei.api.Api;
import com.blankj.utilcode.util.NetworkUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：网络请求类
 */
public class MyRetrofitUtils {

    //单例
    private static MyRetrofitUtils myRetrofitUtils;
    private final Retrofit retrofit;

    private MyRetrofitUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//日志拦截器
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.BASE_URL)
                .build();
    }

    public static MyRetrofitUtils getInstance() {
        if (myRetrofitUtils == null) {
            synchronized (MyRetrofitUtils.class){
                if (myRetrofitUtils == null) {
                    myRetrofitUtils = new MyRetrofitUtils();
                }
            }
        }
        return myRetrofitUtils;
    }

    public <T>T creatView(Class<T> tClass){
        return retrofit.create(tClass);
    }

    public boolean isNet(){
        return NetworkUtils.isConnected();
    }
}
