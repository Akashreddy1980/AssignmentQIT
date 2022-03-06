package com.aimsmart.app.assignmentqit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface dataAPI {
    @GET("v2/top-headlines?sources=techcrunch&apiKey=b614173ef3cc4d5782e43d8ede8efbf8")
    Call<data1> getdata();
}
