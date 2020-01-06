package com.bawei.wangjiangwei.model;

import com.bawei.wangjiangwei.api.Api;
import com.bawei.wangjiangwei.api.HomeApiService;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.entity.LeftEntity;
import com.bawei.wangjiangwei.model.entity.RightEntity;
import com.bawei.wangjiangwei.utils.MyRetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：model层
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getLeftData(ModelCallback modelCallback) {
        MyRetrofitUtils.getInstance().creatView(HomeApiService.class)
                .getLeftData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftEntity leftEntity) {
                        modelCallback.success(leftEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRightData(HashMap<String, String> params, ModelCallback modelCallback) {
        MyRetrofitUtils.getInstance().creatView(HomeApiService.class)
                .getRightData(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightEntity rightEntity) {
                        modelCallback.success(rightEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
