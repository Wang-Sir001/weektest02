package com.bawei.wangjiangwei.presenter;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.HomeModel;

import java.util.HashMap;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：p层
 */
public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresenter {
    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getLeftData() {
        model.getLeftData(new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }

    @Override
    public void getRightData(HashMap<String, String> params) {
        model.getRightData(params, new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }
}
