package com.aimsmart.app.assignmentqit;

import com.google.gson.annotations.SerializedName;

public class data2 {
    @SerializedName("name")
    String name;

    public data2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
