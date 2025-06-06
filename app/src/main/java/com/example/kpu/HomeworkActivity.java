package com.example.kpu;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpu.adapter.HomeworkAdapter;
import com.example.kpu.util.DataUtil;

public class HomeworkActivity extends AppCompatActivity {

    private RecyclerView rv_list;
    private HomeworkAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        setup();
    }

    private void setup(){
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        adapter = new HomeworkAdapter();
        adapter.setDatas(DataUtil.getHomeworkDatas(App.getLoginUser().id));

        rv_list = findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(adapter);
    }
}
