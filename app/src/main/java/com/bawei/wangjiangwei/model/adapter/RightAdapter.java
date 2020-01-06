package com.bawei.wangjiangwei.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.model.entity.RightEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * 姓名：王江伟
 * 时间：2020年1月6日10:24:29
 * 作用：右侧列表
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyViewHolder> {

    private Context context;
    private List<RightEntity.DataBean> list;

    public RightAdapter(Context context, List<RightEntity.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.right_item_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context)
                .load(list.get(position).getGoods_thumb())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(holder.imgR);

        holder.nameR.setText(list.get(position).getGoods_english_name());
        holder.typeR.setText(list.get(position).getGoods_name());
        holder.priceR.setText(list.get(position).getCurrency_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.r_img)
        ImageView imgR;
        @BindView(R.id.r_name)
        TextView nameR;
        @BindView(R.id.r_type)
        TextView typeR;
        @BindView(R.id.r_price)
        TextView priceR;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
