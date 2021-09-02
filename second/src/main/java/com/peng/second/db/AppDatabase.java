package com.peng.second.db;

import android.content.Context;

import com.peng.second.dao.UserDao;
import com.peng.second.entity.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * create by Peng
 * on 2021-09-02 22:55
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    private static final Object sLock = new Object();
    public abstract UserDao userDao();

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user.db")
                                .build();
            }
            return INSTANCE;
        }
    }
}