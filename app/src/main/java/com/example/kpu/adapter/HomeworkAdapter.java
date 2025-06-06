package com.example.kpu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpu.R;
import com.example.kpu.bean.Homework;

import java.util.List;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.ViewHolder> {

    private List<Homework> datas;

    private boolean noDateMode = false;

    public void setNoDateMode(boolean noDateMode) {
        this.noDateMode = noDateMode;
    }

    public void setDatas(List<Homework> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_homework, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.showData(position, datas,noDateMode);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_date;
        private TextView tv_detail;
        private TextView tv_subject;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_detail = itemView.findViewById(R.id.tv_detail);
            tv_subject = itemView.findViewById(R.id.tv_subject);
        }

        public void showData(int position, List<Homework> datas,boolean noDateMode) {
            Homework data = datas.get(position);
            if (!noDateMode){
                if (position != 0) {
                    Homework data_last = datas.get(position - 1);
                    if (data_last.date.equals(data.date)) {
                        tv_date.setVisibility(View.GONE);
                    } else {
                        tv_date.setVisibility(View.VISIBLE);
                    }
                } else {
                    tv_date.setVisibility(View.VISIBLE);
                }
                tv_date.setText(data.date);
                tv_detail.setText(data.detail);
                tv_subject.setText(data.subject);
            }else {
                tv_date.setVisibility(View.GONE);
                tv_detail.setText(data.detail);
                tv_subject.setText(data.subject+" / "+data.date);
            }

        }
    }
}
