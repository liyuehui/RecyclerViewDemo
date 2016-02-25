package com.example.lyh.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;

/**
 * Created by LYH on 2016/2/24.
 */
public interface OnRecyclerViewScrollLocationListener {
    void onTopWhenScrollIdle(RecyclerView recyclerView);

    void onBottomWhenScrollIdle(RecyclerView recyclerView);
}
