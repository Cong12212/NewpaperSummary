package com.example.week09;

public class News {

    private String nameNews;
    private int idNews;

    public News(String topicName,int topicID){
        this.nameNews=topicName;
        this.idNews=topicID;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public void setNameNews(String nameNews) {
        this.nameNews = nameNews;
    }

    public int getIdNews() {
        return idNews;
    }

    public String getNameNews() {
        return nameNews;
    }
}
