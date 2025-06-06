package com.example.kpu.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.kpu.R;

public class MyMenuView extends LinearLayout {
    public MyMenuView(Context context) {
        super(context);
        initView(context,null);
    }

    public MyMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public MyMenuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    public MyMenuView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs);
    }

    private ImageView iv_menu;
    private TextView tv_menu;

    private void initView(Context context,AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.layout_menu, this);

        iv_menu = findViewById(R.id.iv_menu);
        tv_menu = findViewById(R.id.tv_menu);

        if (attrs!=null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyMenuView);
            setText(typedArray.getString(R.styleable.MyMenuView_menu_text));
            setIcon(typedArray.getResourceId(R.styleable.MyMenuView_mine_icon, -1));
            typedArray.recycle();
        }
    }

    public void setText(String text){
        tv_menu.setText(text);
    }

    public void setIcon(int res){
        iv_menu.setImageResource(res);
    }
}
