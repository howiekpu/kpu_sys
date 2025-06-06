package com.example.kpu;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kpu.bean.User;
import com.example.kpu.db.UserDbHelper;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText etAccount, etPassword, etName, etClazz;
    private UserDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 初始化数据库帮助类
        dbHelper = new UserDbHelper(this);

        // 绑定视图
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        etName = findViewById(R.id.et_name);
        etClazz = findViewById(R.id.et_clazz);

        // 注册按钮点击事件
        findViewById(R.id.bt_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // 获取用户输入
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String clazz = etClazz.getText().toString().trim();

        // 简单的输入验证
        if (account.isEmpty() || password.isEmpty() || name.isEmpty() || clazz.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // 创建 User 对象
        User user = new User();
        user.id = System.currentTimeMillis(); // 使用当前时间作为ID
        user.account = account;
        user.name = name;
        user.clazz = clazz;

        // 将用户信息插入数据库
        long result = dbHelper.registerUser(user);

        // 检查注册是否成功
        if (result != -1) {
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            // 跳转到登录页面或其他页面
            finish();
        } else {
            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}