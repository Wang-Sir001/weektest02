package com.bawei.wangjiangwei.base.mvp;

import java.lang.ref.WeakReference;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：p层封装
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    //创建出来两层
    public M model;
    //使用引用和解绑来解决内存泄漏
    private WeakReference<V> weakReference;

    //声明model层
    public BasePresenter(){
        model = initModel();
    }

    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    //绑定和解绑
    public void detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }

    protected abstract M initModel();

    //提供外界接口
    public V getView(){
        return weakReference.get();
    }
}
