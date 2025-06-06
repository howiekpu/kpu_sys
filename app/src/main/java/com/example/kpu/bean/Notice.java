package com.example.kpu.bean;

import java.io.Serializable;

public class Notice implements Serializable {
    public long id;//使用时间戳作为id
    public long user_id;
    public int color;
    public int img;
    public String detail;
    //public long date;
    public String date;

    public Notice(){

    }

    public Notice(long id, long user_id, int color, int img, String detail, String date) {
        this.id = id;
        this.user_id = user_id;
        this.color = color;
        this.img = img;
        this.detail = detail;
        this.date = date;
    }
}
