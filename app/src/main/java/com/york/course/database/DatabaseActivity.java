package com.york.course.database;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.york.course.R;

import java.util.List;
import java.util.Random;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

//        MyDatabaseInstance instance = Room
//                .databaseBuilder(this, MyDatabaseInstance.class, "Database")
//                .build();
//
//        instance.getUserDao().retrieveFirstOne();

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.commit();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseInstance instance = Room
                        .databaseBuilder(DatabaseActivity.this, MyDatabaseInstance.class, "Database")
                        .build();

                new AsyncTaskOperation(instance, new AsyncTaskOperation.Actions() {
                    @Override
                    public void onReturn(List<UserTable> dataList) {
                        List<UserTable> data = dataList;
                    }
                }).execute(getUser());
            }
        });
    }

    UserTable getUser() {
        UserTable userTable = new UserTable();
        userTable.setName(new Random().toString());
        userTable.setAge(100);
        userTable.setJobName("");

        return userTable;
    }
}