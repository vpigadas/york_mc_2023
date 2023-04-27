package com.york.course.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.york.course.R;

public class RecyclerHolderV2 extends RecyclerView.ViewHolder {

    public RecyclerHolderV2(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String data) {
        TextView textView = itemView.findViewById(R.id.textView);
        textView.setText(data);
    }
}
