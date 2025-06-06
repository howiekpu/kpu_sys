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

import com.example.kpu.view.MyMenuView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_close;
    private MyMenuView mmv_0,mmv_1,mmv_2,mmv_3,mmv_4,mmv_5,mmv_6,mmv_7,mmv_8,mmv_9,mmv_10;
    private TextView bt_logout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setup();
    }

    private void setup(){

        TextView tv_user_name = findViewById(R.id.tv_user_name);
        TextView tv_user_clazz = findViewById(R.id.tv_user_clazz);
        tv_user_name.setText(App.getLoginUser().name);
        tv_user_clazz.setText(App.getLoginUser().clazz);

        iv_close = findViewById(R.id.iv_close);
        iv_close.setOnClickListener(this);
        bt_logout = findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(this);

        mmv_0 = findViewById(R.id.mmv_0);
        mmv_1 = findViewById(R.id.mmv_1);
        mmv_2 = findViewById(R.id.mmv_2);
        mmv_3 = findViewById(R.id.mmv_3);
        mmv_4 = findViewById(R.id.mmv_4);
        mmv_5 = findViewById(R.id.mmv_5);
        mmv_6 = findViewById(R.id.mmv_6);
        mmv_7 = findViewById(R.id.mmv_7);
        mmv_8 = findViewById(R.id.mmv_8);
        mmv_9 = findViewById(R.id.mmv_9);
        mmv_10 = findViewById(R.id.mmv_10);
        mmv_0.setOnClickListener(this);
        mmv_1.setOnClickListener(this);
        mmv_2.setOnClickListener(this);
        mmv_3.setOnClickListener(this);
        mmv_4.setOnClickListener(this);
        mmv_5.setOnClickListener(this);
        mmv_6.setOnClickListener(this);
        mmv_7.setOnClickListener(this);
        mmv_8.setOnClickListener(this);
        mmv_9.setOnClickListener(this);
        mmv_10.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();
        if (vid == R.id.mmv_0){
            finish();
        }else if (vid==R.id.mmv_1){
            startActivity(new Intent(this,HomeworkActivity.class));
            finish();
        }else if (vid==R.id.iv_close){
            finish();
        }else if (vid==R.id.bt_logout){
            setResult(Activity.RESULT_OK);
            finish();
            App.setLoginUser(null);
        }else {
            Toast.makeText(this,"developing",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_null, R.anim.slide_out_left);
    }
}
