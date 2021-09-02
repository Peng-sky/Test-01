package com.peng.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.peng.second.db.AppDatabase;
import com.peng.second.entity.User;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    private AppDatabase mAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.click_event);
        mAppDatabase = AppDatabase.getInstance(getApplicationContext());
        mAppDatabase.userDao().getAllList().observe(MainActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.d(TAG, "onChanged: " + users);
            }
        });
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {

//                Log.d(TAG, "run: " + value);
//                for (User user : value) {
//                    Log.d(TAG, "run: " + value);
//                }
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExecutorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        List<User> all = mAppDatabase.userDao().getAll();
                        mAppDatabase.userDao().deleteUser(all.get(0));
                    }
                });
            }
        });


        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExecutorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        List<User> all = mAppDatabase.userDao().getAll();
                        Log.d(TAG, "run: " + all);
                    }
                });

            }
        });

        findViewById(R.id.insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExecutorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User("AA");
                        User user1 = new User("BB");
                        mAppDatabase.userDao().insert(user);
                        mAppDatabase.userDao().insert(user1);
                    }
                });
            }
        });
    }
}