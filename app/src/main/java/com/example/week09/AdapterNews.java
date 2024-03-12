package com.example.week09;

import static androidx.core.content.ContextCompat.startActivity;

import android.adservices.topics.Topic;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {

    private List<News> dataList;
    private OnItemClickListener mListener;

    public AdapterNews(List<News> dataList) {
        this.dataList = dataList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = dataList.get(position).getNameNews();
        holder.textView.setText(text);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition(); // Lấy vị trí cụ thể của item

                if (mListener != null && clickedPosition != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(clickedPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTitle);
        }
    }
}