package com.example.week09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public  class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterNews adapter;
    private List<News> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listNews);
        dataList = new ArrayList<>();

        dataList.add(new News("THANH NIEN",1));
        dataList.add(new News("VNEXPRESS",2));
        dataList.add(new News("DAN TRI",3));
        dataList.add(new News("TUOI TRE",4));

        adapter = new AdapterNews(dataList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new AdapterNews.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                News clickedNews = dataList.get(position);
                Intent intent = new Intent(MainActivity.this, TopicNews.class);
                Bundle myData = new Bundle();
                myData.putString("nameNews", clickedNews.getNameNews());
                intent.putExtras(myData);
                startActivity(intent);
            }
        });
    }
}