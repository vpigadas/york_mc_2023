package com.york.course.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(UserTable userTable);

//    @Insert
//    void insert(UserTable userTable) throws Exception;
//
//    @Update
//    void update(UserTable userTable) throws Exception;

    @Delete
    void delete(UserTable userTable);

    @Query("SELECT * FROM User")
    @NonNull
    List<UserTable> retrieve();

    @Query("SELECT * FROM User LIMIT 1")
    @Nullable
    UserTable retrieveFirstOne();

    @Query("SELECT * FROM User WHERE name LIKE :username")
    @NonNull
    List<UserTable> retrieve(String username);
}
