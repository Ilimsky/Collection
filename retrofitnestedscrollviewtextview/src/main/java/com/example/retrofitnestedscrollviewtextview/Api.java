package com.example.retrofitnestedscrollviewtextview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("ky")
    Call<List<Post>> getPosts();
}
