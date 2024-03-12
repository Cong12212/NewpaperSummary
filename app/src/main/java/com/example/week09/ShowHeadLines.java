package com.example.week09;

import static android.app.ProgressDialog.show;
import static android.content.Intent.getIntent;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowHeadLines extends Activity {
    // Main category has already been selected by user: ‘World News’, Business’, ...
// ["urlCaption", "urlAddress"] comes in a bundle sent by main thread
// here we access RSS-feed and show corresponding headlines
    ArrayList<SingleItem> newsList = new ArrayList<SingleItem>();
    ListView myListView; String urlAddress = "", urlCaption = ""; SingleItem selectedNewsItem;

    TextView titleView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_new);
        myListView = (ListView)this.findViewById(R.id.listTopicNews);

        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        urlAddress = myBundle.getString("urlAddress");
        urlCaption = myBundle.getString("urlCaption");
        String newspaper = myBundle.getString("nameNews", "NULL");

        titleView=(TextView)this.findViewById(R.id.titleView);
        myListView = (ListView)this.findViewById(R.id.listTopicNews);
        titleView.setText("ITEM IN CHANNEL "+urlCaption+" - "+newspaper);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View v, int index, long id) {
                selectedNewsItem = newsList.get(index);
                showNiceDialogBox(selectedNewsItem, getApplicationContext());
            }});

        DownloadRssFeed downloader = new DownloadRssFeed(ShowHeadLines.this);
        downloader.execute(urlAddress, urlCaption);
    }
    public void showNiceDialogBox(SingleItem selectedStoryItem, Context context){

        String title = selectedStoryItem.getTitle();
        String description = selectedStoryItem.getDescription();
        if (title.toLowerCase().equals(description.toLowerCase())){ description = ""; }
        try {
            final Uri storyLink = Uri.parse(selectedStoryItem.getLink());
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
            myBuilder.setIcon(R.drawable.ic_launcher_foreground)
                    .setTitle(Html.fromHtml(urlCaption) )
                    .setMessage(title + "\n\n" + Html.fromHtml(description) + "\n").setPositiveButton("Close", null)
                    .setNegativeButton("More", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichOne) {
                            Intent browser = new Intent(Intent.ACTION_VIEW, storyLink);
                            startActivity(browser);
                        }})
                    .show();
        }
        catch (Exception e) { Log.e("Error DialogBox", e.getMessage() ); }
    }
}
