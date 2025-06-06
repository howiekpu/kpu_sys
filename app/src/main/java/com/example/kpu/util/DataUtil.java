package com.example.kpu.util;

import android.graphics.Color;

import com.example.kpu.R;
import com.example.kpu.bean.Homework;
import com.example.kpu.bean.Notice;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static List<Homework> getHomeworkDatas(long user_id){
        List<Homework> datas = new ArrayList<>();
        long id = System.currentTimeMillis();
        datas.add(new Homework(id++,user_id,"English","Learn Chapter 5 with one Essay","Today"));
        datas.add(new Homework(id++,user_id,"Maths","Exercise Trigonometry 1st topic","Today"));
        datas.add(new Homework(id++,user_id,"Hindi","Hindi writing 3 pages","Today"));
        datas.add(new Homework(id++,user_id,"Social Science","Test for History first session","Today"));

        datas.add(new Homework(id++,user_id,"English","Learn Chapter 5 with one Essay","Yesterday"));
        datas.add(new Homework(id++,user_id,"Maths","Exercise Trigonometry 1st topic","Yesterday"));

        datas.add(new Homework(id++,user_id,"English","Learn Chapter 5 with one Essay","16 March 2020"));
        datas.add(new Homework(id++,user_id,"Maths","Exercise Trigonometry 1st topic","16 March 2020"));

        datas.add(new Homework(id++,user_id,"English","Learn Chapter 5 with one Essay","15 March 2020"));
        datas.add(new Homework(id++,user_id,"Maths","Exercise Trigonometry 1st topic","15 March 2020"));

        return datas;

    }

    public static List<Notice> getNoticeDatas(long user_id){
        List<Notice> datas = new ArrayList<>();
        long id = System.currentTimeMillis();
        datas.add(new Notice(id++,user_id,R.drawable.xmlbg_d4ffea_r15dp, R.mipmap.ic_notice_0,"School is going for vacation in next month","02 March 2020"));
        datas.add(new Notice(id++,user_id,R.drawable.xmlbg_d4f5ff_r15dp,R.mipmap.ic_notice_1,"Summer Book Fair at School Campus in June","02 March 2020"));
        datas.add(new Notice(id++,user_id,R.drawable.xmlbg_ffd4d4_r15dp,R.mipmap.ic_notice_2,"School is going for vacation in next month","02 March 2020"));

        return datas;

    }
}
