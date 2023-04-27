package com.york.course.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.york.course.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private List<String> arrayData;

    public RecyclerAdapter(List<String> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_item_1, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        String item = arrayData.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
