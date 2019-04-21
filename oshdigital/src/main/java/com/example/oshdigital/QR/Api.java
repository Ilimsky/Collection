package com.example.oshdigital.QR;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    /*@GET("all")
    Call<List<Model>> galleryContent();*/

    @GET("place/all/{id}")
    Call<List<Model>> galleryContent(@Path("id") int result);

}
