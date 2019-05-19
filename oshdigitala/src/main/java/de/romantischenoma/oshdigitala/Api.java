package de.romantischenoma.oshdigitala;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("data/{id}")
    Call<List<Model>> galleryContent(@Path("id") int result);

}
