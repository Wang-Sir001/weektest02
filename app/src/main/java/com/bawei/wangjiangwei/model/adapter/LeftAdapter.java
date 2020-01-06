package com.bawei.wangjiangwei.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.model.entity.LeftEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：左侧列表
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyViewHolder> {

    private Context context;
    private List<String> list;

    public LeftAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.left_item_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftCallback.name(holder.tv.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv)
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public  LeftCallback leftCallback;

    public void setLeftCallback(LeftCallback leftCallback) {
        this.leftCallback = leftCallback;
    }

    public interface LeftCallback{
        void name(String name);
    }
}
