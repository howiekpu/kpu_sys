package com.example.kpu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpu.adapter.HomeworkAdapter;
import com.example.kpu.adapter.NoticeAdapter;
import com.example.kpu.util.DataUtil;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_menu;
    private RecyclerView rv_list_notice;
    private RecyclerView rv_list;
    private NoticeAdapter adapter_notice;
    private HomeworkAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup(){
        TextView tv_user_name = findViewById(R.id.tv_user_name);
        TextView tv_user_clazz = findViewById(R.id.tv_user_clazz);
        tv_user_name.setText(App.getLoginUser().name);
        tv_user_clazz.setText(App.getLoginUser().clazz);

        iv_menu = findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,MenuActivity.class),101);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_null);
            }
        });

        adapter_notice = new NoticeAdapter();
        adapter_notice.setDatas(DataUtil.getNoticeDatas(App.getLoginUser().id));

        rv_list_notice = findViewById(R.id.rv_list_notice);
        rv_list_notice.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv_list_notice.setAdapter(adapter_notice);

        adapter = new HomeworkAdapter();
        adapter.setNoDateMode(true);
        adapter.setDatas(DataUtil.getHomeworkDatas(App.getLoginUser().id));

        rv_list = findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode!= Activity.RESULT_OK){
            return;
        }
        switch (requestCode){
            case 101:
                Toast.makeText(this, "Logout successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
        }
    }

    private long backPressedTime = 0; // 记录第一次按下返回键的时间
    private static final int BACK_PRESS_INTERVAL = 2000; // 两次按下的时间间隔（2 秒）

    @Override
    public void onBackPressed() {
        if (backPressedTime + BACK_PRESS_INTERVAL > System.currentTimeMillis()) {
            // 如果两次按下的时间间隔小于 2 秒，则退出应用
            super.onBackPressed(); // 调用父类的退出逻辑
            finish(); // 结束当前 Activity
        } else {
            // 第一次按下返回键，提示用户再按一次退出
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
        }
        // 更新按下返回键的时间
        backPressedTime = System.currentTimeMillis();
    }
}
