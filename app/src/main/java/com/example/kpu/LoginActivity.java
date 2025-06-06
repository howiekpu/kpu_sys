package com.example.kpu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kpu.bean.User;
import com.example.kpu.db.UserDbHelper;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etAccount, etPassword;
    private UserDbHelper dbHelper;
    private SharedPreferences sharedPreferences;

    // SharedPreferences 的键
    private static final String PREFS_NAME = "LoginPrefs";
    private static final String KEY_ACCOUNT = "account";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_REMEMBER_ME = "rememberMe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 初始化数据库帮助类
        dbHelper = new UserDbHelper(this);

        // 绑定视图
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);

        // 初始化 SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // 自动填充账号和密码
        autoFillLoginInfo();

        // 登录按钮点击事件
        findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // 注册按钮点击事件
        findViewById(R.id.bt_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到注册页面
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void autoFillLoginInfo() {
        // 从 SharedPreferences 中读取保存的账号和密码
        String savedAccount = sharedPreferences.getString(KEY_ACCOUNT, "");
        String savedPassword = sharedPreferences.getString(KEY_PASSWORD, "");
        boolean rememberMe = sharedPreferences.getBoolean(KEY_REMEMBER_ME, false);

        // 如果之前选择了“记住我”，则自动填充账号和密码
        if (rememberMe) {
            etAccount.setText(savedAccount);
            etPassword.setText(savedPassword);
        }
    }

    private void loginUser() {
        // 获取用户输入
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // 简单的输入验证
        if (account.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // 查询用户信息
        User user = dbHelper.loginUser(account);

        // 验证用户信息
        if (user != null) {
            // 假设密码验证成功（实际项目中需要加密验证）
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

            // 保存账号和密码到 SharedPreferences
            saveLoginInfo(account, password, true);

            App.setLoginUser(user);

            // 跳转到主页面或其他页面
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid account or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLoginInfo(String account, String password, boolean rememberMe) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (rememberMe) {
            // 如果选择了“记住我”，则保存账号和密码
            editor.putString(KEY_ACCOUNT, account);
            editor.putString(KEY_PASSWORD, password);
            editor.putBoolean(KEY_REMEMBER_ME, true);
        } else {
            // 如果没有选择“记住我”，则清除保存的账号和密码
            editor.remove(KEY_ACCOUNT);
            editor.remove(KEY_PASSWORD);
            editor.putBoolean(KEY_REMEMBER_ME, false);
        }
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}