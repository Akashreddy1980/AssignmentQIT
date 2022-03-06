package com.aimsmart.app.assignmentqit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class data1 {
    @SerializedName("articles")
    List<data> data;

    public List<com.aimsmart.app.assignmentqit.data> getData() {
        return data;
    }

    public void setData(List<com.aimsmart.app.assignmentqit.data> data) {
        this.data = data;
    }
}
