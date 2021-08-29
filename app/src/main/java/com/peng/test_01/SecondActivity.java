package com.peng.test_01;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Dialog;
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
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.click_event);
        viewById.setOnClickListener(v -> {
            ActivityOptions activityOptions = ActivityOptions.makeBasic();
            activityOptions.setLaunchDisplayId(1);
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent, activityOptions.toBundle());
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityManager activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1000);
        for (ActivityManager.RunningTaskInfo runningTask : runningTasks) {
            Log.d(TAG, "onResume: " + runningTask.toString());
        }
    }
}
