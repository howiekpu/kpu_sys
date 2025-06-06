package com.example.kpu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpu.R;
import com.example.kpu.bean.Notice;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    private List<Notice> datas;

    public void setDatas(List<Notice> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_notice, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.showData(position, datas);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout cc_item;
        private ImageView iv_logo;
        private TextView tv_date;
        private TextView tv_detail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cc_item = itemView.findViewById(R.id.cc_item);
            iv_logo = itemView.findViewById(R.id.iv_logo);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_detail = itemView.findViewById(R.id.tv_detail);
        }

        public void showData(int position, List<Notice> datas) {
            Notice data = datas.get(position);
            cc_item.setBackgroundResource(data.color);
            iv_logo.setImageResource(data.img);
            tv_date.setText(data.date);
            tv_detail.setText(data.detail);

        }
    }
}
