package com.york.course.recyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.york.course.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new DynamicRecyclerAdapter(getDataList()));
    }

    private List<String> getDataList() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            dataList.add(String.valueOf(i));
        }
        return dataList;
    }
}