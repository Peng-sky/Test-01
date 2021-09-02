package com.peng.second.dao;

import com.peng.second.entity.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * create by Peng
 * on 2021-09-02 22:53
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user")
    LiveData<List<User>>  getAllList();

    @Insert
    void insert(User user);

    @Delete
    void deleteUser(User user);



}
