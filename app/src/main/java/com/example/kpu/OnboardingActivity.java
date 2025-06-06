package com.example.kpu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.kpu.adapter.OnboardingPagerAdapter;

public class OnboardingActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private OnboardingPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new OnboardingPagerAdapter(this,viewPager);
        viewPager.setAdapter(pagerAdapter);

    }
}