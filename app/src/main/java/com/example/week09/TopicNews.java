package com.example.week09;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TopicNews extends AppCompatActivity {
    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;

    TextView titleView;
    Context context;
    SingleItem selectedNewsItem;
    String [][] myUrlThanhNien = {
            {"https://thanhnien.vn/rss/thoi-su.rss", "Thời Sự"},
            {"https://thanhnien.vn/rss/the-gioi.rss", "Thế giới"},
            {"https://thanhnien.vn/rss/kinh-te.rss", "Kinh tế"},
            {"https://thanhnien.vn/rss/doi-song.rss", "Đời sống"},
            {"https://thanhnien.vn/rss/suc-khoe.rss", "Sức khỏe"},
            {"https://thanhnien.vn/rss/gioi-tre.rss", "Giới trẻ"},
            {"https://thanhnien.vn/rss/giao-duc.rss", "Giáo dục"},
            {"https://thanhnien.vn/rss/du-lich.rss", "Du lịch"},
            {"https://thanhnien.vn/rss/van-hoa.rss", "Văn hóa"},
            {"https://thanhnien.vn/rss/giai-tri.rss", "Giải trí"},
            {"https://thanhnien.vn/rss/the-thao.rss", "Thể Thao"},
            {"https://thanhnien.vn/rss/cong-nghe-game.rss", "Công nghệ - Game"},
            {"https://thanhnien.vn/rss/xe.rss", "Xe"},
            {"https://thanhnien.vn/rss/video.rss", "Video"},
            {"https://thanhnien.vn/rss/tieu-dung-thong-minh.rss", "Tiêu dùng"},
            {"https://thanhnien.vn/rss/thoi-trang-tre.rss", "Thời trang trẻ"},

    };
    String [][] myUrlVnexpress = {
            {"https://vnexpress.net/rss/thoi-su.rss", "Thời Sự"},
            {"https://vnexpress.net/rss/goc-nhin.rss", "Góc nhìn"},
            {"https://vnexpress.net/rss/the-gioi.rss", "Thế giới"},
            {"https://vnexpress.net/rss/video.rss", "Video"},
            {"https://vnexpress.net/rss/podcast.rss", "Podcasts"},
            {"https://vnexpress.net/rss/kinh-doanh.rss", "Kinh doanh"},
            {"https://vnexpress.net/rss/bat-dong-san.rss", "Bất động sản"},
            {"https://vnexpress.net/rss/khoa-hoc.rss", "Khoa học"},
            {"https://vnexpress.net/rss/giai-tri.rss", "Giải trí"},
            {"https://vnexpress.net/rss/the-thao.rss", "Thể thao"},
            {"https://vnexpress.net/rss/phap-luat.rss", "Pháp luật"},
            {"https://vnexpress.net/rss/giao-duc.rss", "Giáo dục"},
            {"https://vnexpress.net/rss/suc-khoe.rss", "Sức khỏe"},
            {"https://vnexpress.net/rss/doi-song.rss", "Đời sống"},
            {"https://vnexpress.net/rss/du-lich.rss", "Du lịch"},
            {"https://vnexpress.net/rss/so-hoa.rss", "Số hóa"},
            {"https://vnexpress.net/rss/xe.rss", "Xe"},
            {"https://vnexpress.net/rss/y-kien.rss", "Ý kiến"},
            {"https://vnexpress.net/rss/tam-su.rss", "Tâm sự"},
            {"https://vnexpress.net/rss/thu-gian.rss", "Thư giãn"},
    };
    String [][] myUrlDanTri = {
            {"https://dantri.com.vn/rss/tin-moi-nhat.rss","Mới nhất"},
            {"https://dantri.com.vn/rss/xa-hoi.rss","Xã hội"},
            {"https://dantri.com.vn/rss/the-gioi.rss","Thế giới"},
            {"https://dantri.com.vn/rss/kinh-doanh.rss","Kinh doanh"},
            {"https://dantri.com.vn/rss/bat-dong-san.rss","Bất động sản"},
            {"https://dantri.com.vn/rss/the-thao.rss","Thể thao"},
            {"https://dantri.com.vn/rss/lao-dong-viec-lam.rss","Việc làm"},
            {"https://dantri.com.vn/rss/tam-long-nhan-ai.rss","Nhân ái"},
            {"https://dantri.com.vn/rss/suc-khoe.rss","Sức khỏe"},
            {"https://dantri.com.vn/rss/van-hoa.rss","Văn hóa"},
            {"https://dantri.com.vn/rss/giai-tri.rss","Giải trí"},
            {"https://dantri.com.vn/rss/o-to-xe-may.rss","Xe++"},
            {"https://dantri.com.vn/rss/suc-manh-so.rss","Sức mạnh số"},
            {"https://dantri.com.vn/rss/giao-duc.rss","Giáo dục"},
            {"https://dantri.com.vn/rss/an-sinh.rss","An sinh"},
            {"https://dantri.com.vn/rss/phap-luat.rss","Pháp luật"},
    };

    String [][] myUrlTuoiTre={
            {"https://tuoitre.vn/rss/video.rss","Video"},
            {"https://tuoitre.vn/rss/thoi-su.rss","Thời sự"},
            {"https://tuoitre.vn/rss/the-gioi.rss","Thế giới"},
            {"https://tuoitre.vn/rss/phap-luat.rss","Pháp luật"},
            {"https://tuoitre.vn/rss/kinh-doanh.rss","Kinh doanh"},
            {"https://tuoitre.vn/rss/cong-nghe.rss","Công nghệ"},
            {"https://tuoitre.vn/rss/xe.rss","Xe"},
            {"https://tuoitre.vn/rss/du-lich.rss","Du lịch"},
            {"https://tuoitre.vn/rss/nhip-song-tre.rss","Nhịp sống trẻ"},
            {"https://tuoitre.vn/rss/van-hoa.rss","Văn hóa"},
            {"https://tuoitre.vn/rss/giai-tri.rss","Giải trí"},
            {"https://tuoitre.vn/rss/the-thao.rss","Thể thao"},
            {"https://tuoitre.vn/rss/giao-duc.rss","Giáo dục"},
            {"https://tuoitre.vn/rss/nha-dat.rss","Nhà đất"},
            {"https://tuoitre.vn/rss/suc-khoe.rss","Sức khỏe"},
            {"https://tuoitre.vn/rss/gia-that.rss","Giả thật"},
            {"https://tuoitre.vn/rss/ban-doc.rss","Bạn đọc"},

    };
    String [][] myUrlCaptionMenu=myUrlThanhNien;
    String[] myUrlCaption = new String[myUrlCaptionMenu.length];
    String[] myUrlAddress = new String[myUrlCaptionMenu.length];
    public static String niceDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy",
                Locale.US);
        return sdf.format(new Date());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_new);

        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        String newspaper = myBundle.getString("nameNews", "NULL");

        titleView=(TextView)this.findViewById(R.id.titleView);
        titleView.setText("CHANNEL IN "+newspaper);

        ChangeURL(newspaper);
        context = getApplicationContext();
        this.setTitle("NPR Headline News\n" + niceDate() );
        myMainListView = (ListView)this.findViewById(R.id.listTopicNews);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
                String urlAddress = myUrlAddress[_index], urlCaption = myUrlCaption[_index];
                Intent callShowHeadlines = new Intent(TopicNews.this, ShowHeadLines.class);
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                myData.putString("nameNews", newspaper);
                callShowHeadlines.putExtras(myData);
                startActivity(callShowHeadlines);
            }
        });
        adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);
    }
    void ChangeURL(String newspaer){
        switch (newspaer){
            case"THANH NIEN":
                myUrlCaptionMenu=myUrlThanhNien;
                break;
            case "VNEXPRESS":
                myUrlCaptionMenu=myUrlVnexpress;
                break;
            case "DAN TRI":
                myUrlCaptionMenu=myUrlDanTri;
                break;
            case "TUOI TRE":
                myUrlCaptionMenu=myUrlTuoiTre;
                break;
            }
        for (int i=0; i<myUrlAddress.length; i++) {
            myUrlAddress[i] = myUrlCaptionMenu[i][0];
            myUrlCaption[i] = myUrlCaptionMenu[i][1];
        }
    }
}
