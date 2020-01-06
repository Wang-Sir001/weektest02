package com.bawei.wangjiangwei.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.base.mvp.IBaseView;
import com.bawei.wangjiangwei.contract.IHomeContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：v层封装
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{

    public P presenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        unbinder = ButterKnife.bind(this);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
        if (presenter != null) {
            unbinder.unbind();
        }
    }
}
