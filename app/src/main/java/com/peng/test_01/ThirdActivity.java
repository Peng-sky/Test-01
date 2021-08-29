package com.peng.test_01;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * create by Peng
 * on 2021-08-22 16:14
 */
public class ThirdActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        View viewById = findViewById(R.id.click_event);
        viewById.setOnClickListener(v -> {
            ActivityOptions activityOptions = ActivityOptions.makeBasic();
            activityOptions.setLaunchDisplayId(1);
            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
            startActivity(intent, activityOptions.toBundle());
        });
    }
}
