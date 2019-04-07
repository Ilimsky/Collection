package com.example.retrofitnestedscrollviewtextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    static final String URL = "http://medonet-001-site3.etempurl.com/api/apigallery/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Post>> call = api.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code: " + response.code());
                }

                List<Post> posts = response.body();


                for (Post post: posts){
                    String content = "";
                    content += "Description: " + post.getDescription() + "\n";
                    content += "Image: " + post.getImageURL() + "\n\n";
                    textView.append(content);

                    /*Picasso.get()
                            .load(post.getDescription().replace("~", "http://medonet-001-site3.etempurl.com/api/apigallery/"))
                            .fit()
                            .centerInside()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher)
                            .into(imageView);*/

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
