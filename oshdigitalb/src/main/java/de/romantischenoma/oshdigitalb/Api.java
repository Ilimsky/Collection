package de.romantischenoma.oshdigitalb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    /*@GET("data/")
    Call<List<Model>> galleryContent();*/

    @GET("posts/")
    Call<List<Model>> galleryContent();
}
