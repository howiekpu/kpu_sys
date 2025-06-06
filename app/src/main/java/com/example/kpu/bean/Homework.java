package com.example.kpu.bean;

import java.io.Serializable;

public class Homework implements Serializable {
    public long id;//使用时间戳作为id
    public long user_id;
    public String subject;
    public String detail;
    //public long date;
    public String date;

    public Homework() {
    }

    public Homework(long id, long user_id, String subject, String detail, String date) {
        this.id = id;
        this.user_id = user_id;
        this.subject = subject;
        this.detail = detail;
        this.date = date;
    }
}
