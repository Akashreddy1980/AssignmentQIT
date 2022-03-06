package com.aimsmart.app.assignmentqit;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class data {

    @SerializedName("publishedAt")
    String time;
//    @SerializedName("sourse")
//    data2 Sourse;
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("urlToImage")
    String url;
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public data2 getSourse() {
//        return Sourse;
//    }
//
//    public void setSourse(data2 sourse) {
//        Sourse = sourse;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public data(String time, String title, String description) {
        this.time = time;
//        this.Sourse = sourse;
        this.title = title;
        this.description = description;
    }
}
