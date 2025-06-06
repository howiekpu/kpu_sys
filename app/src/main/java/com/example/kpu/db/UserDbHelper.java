package com.example.kpu.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kpu.bean.User;

public class UserDbHelper extends SQLiteOpenHelper {

    // 数据库信息
    private static final String DATABASE_NAME = "UserDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // 表名
    private static final String TABLE_NAME = "users";

    // 列名
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ACCOUNT = "account";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CLAZZ = "clazz";

    // 创建表的SQL语句
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_ACCOUNT + " TEXT UNIQUE, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_CLAZZ + " TEXT)";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // 注册方法
    public long registerUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, user.id);
        values.put(COLUMN_ACCOUNT, user.account);
        values.put(COLUMN_NAME, user.name);
        values.put(COLUMN_CLAZZ, user.clazz);

        // 插入数据
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    // 登录方法
    @SuppressLint("Range")
    public User loginUser(String account) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ACCOUNT + " = ?", new String[]{account}, null, null, null);

        User user = null;
        if (cursor != null && cursor.moveToFirst()) {
            user = new User();
            user.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
            user.account = cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT));
            user.name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            user.clazz = cursor.getString(cursor.getColumnIndex(COLUMN_CLAZZ));
            cursor.close();
        }
        db.close();
        return user;
    }
}