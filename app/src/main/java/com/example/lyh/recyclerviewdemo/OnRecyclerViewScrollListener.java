package com.example.lyh.recyclerviewdemo;

/**
 * Created by LYH on 2016/2/24.
 */
public interface OnRecyclerViewScrollListener {
    public void onScrollStateChanged(android.support.v7.widget.RecyclerView recyclerView, int newState);

    public void onScrolled(android.support.v7.widget.RecyclerView recyclerView, int dx, int dy);
}
