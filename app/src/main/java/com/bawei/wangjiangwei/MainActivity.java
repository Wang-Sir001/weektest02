package com.bawei.wangjiangwei;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bawei.wangjiangwei.base.BaseActivity;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.adapter.LeftAdapter;
import com.bawei.wangjiangwei.model.adapter.RightAdapter;
import com.bawei.wangjiangwei.model.entity.LeftEntity;
import com.bawei.wangjiangwei.model.entity.RightEntity;
import com.bawei.wangjiangwei.presenter.HomePresenter;
import com.bawei.wangjiangwei.utils.MyRetrofitUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.BindView;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：主页展示
 */
public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {
    @BindView(R.id.rv_left)
    RecyclerView leftRv;
    @BindView(R.id.rv_right)
    RecyclerView rightRv;
    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        leftRv.setLayoutManager(new LinearLayoutManager(this));
        rightRv.setLayoutManager(new GridLayoutManager(this,2));
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        if (MyRetrofitUtils.getInstance().isNet()){
            presenter.getLeftData();

        }else {
            Toast.makeText(this, "无网络连接", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Object o) {
        if (o instanceof LeftEntity){
            Log.i("xxx",""+o);
            LeftAdapter leftAdapter = new LeftAdapter(this,((LeftEntity) o).category);
            leftRv.setAdapter(leftAdapter);

            leftAdapter.setLeftCallback(new LeftAdapter.LeftCallback() {
                @Override
                public void name(String name) {
                    EventBus.getDefault().post(name);
                }
            });
        }else if (o instanceof RightEntity){
            RightAdapter rightAdapter = new RightAdapter(this,((RightEntity) o).getData());
            rightRv.setAdapter(rightAdapter);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void leftString(String name){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("category",name);

        presenter.getRightData(hashMap);
    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
