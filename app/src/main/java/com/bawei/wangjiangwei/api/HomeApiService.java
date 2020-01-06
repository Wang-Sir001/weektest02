package com.bawei.wangjiangwei.api;

import com.bawei.wangjiangwei.model.entity.LeftEntity;
import com.bawei.wangjiangwei.model.entity.RightEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：提供接口
 */
public interface HomeApiService {

    @GET("category")
    Observable<LeftEntity> getLeftData();

    @GET("shopByCategory")
    Observable<RightEntity> getRightData(@QueryMap HashMap<String,String> params);
}
