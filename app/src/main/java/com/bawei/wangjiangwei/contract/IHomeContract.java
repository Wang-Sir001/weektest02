package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.base.mvp.IBaseModel;
import com.bawei.wangjiangwei.base.mvp.IBaseView;

import java.util.HashMap;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：契约类
 */
public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getLeftData(ModelCallback modelCallback);
        void getRightData(HashMap<String,String> params,ModelCallback modelCallback);

        interface ModelCallback{
            void success(Object o);
            void error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(Object o);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getLeftData();
        void getRightData(HashMap<String,String> params);
    }
}
