package com.york.course.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.york.course.R;

import java.util.List;

public class DynamicRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> arrayData;

    public DynamicRecyclerAdapter(List<String> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        if (viewType == R.layout.holder_item_1) {
            return new RecyclerHolder(view);
        } else {
            return new RecyclerHolderV2(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String item = arrayData.get(position);
        if (holder instanceof RecyclerHolder) {
            ((RecyclerHolder) holder).bind(item);
        } else if (holder instanceof RecyclerHolderV2) {
            ((RecyclerHolderV2) holder).bind(item);
        }

    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return R.layout.holder_item_1;
        }
        return R.layout.holder_item_2;
    }
}
