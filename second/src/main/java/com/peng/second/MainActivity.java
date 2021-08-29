package com.peng.second;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.click_event);
        viewById.setOnClickListener(v -> {
            ActivityOptions activityOptions = ActivityOptions.makeBasic();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.peng.test_01", "com.peng.test_01.SecondActivity"));
            startActivity(intent);
        });
    }
}