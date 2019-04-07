package com.example.traveldirectory.C;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.traveldirectory.Basic.MovieModel;
import com.example.traveldirectory.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class CActivity extends AppCompatActivity {

    private ImageView ivMovieIcon1;
    private ImageView ivMovieIcon2;
    private ImageView ivMovieIcon3;
    private ImageView ivMovieIcon4;
    private ImageView ivMovieIcon5;
    private ImageView ivMovieIcon6;
    private ImageView ivMovieIcon7;
    private ImageView ivMovieIcon8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        // Showing and Enabling clicks on the Home/Up button
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // setting up text views and stuff
        setUpUIViews();

        // recovering data from MainActivity, sent via intent
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String json = bundle.getString("movieModel"); // getting the model from MainActivity send via extras
            MovieModel movieModel = new Gson().fromJson(json, MovieModel.class);

            // Then later, when you want to display image
            ImageLoader.getInstance().displayImage(movieModel.getImage1(), ivMovieIcon1, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage2(), ivMovieIcon2, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage3(), ivMovieIcon3, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage4(), ivMovieIcon4, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage5(), ivMovieIcon5, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage6(), ivMovieIcon6, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage7(), ivMovieIcon7, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage8(), ivMovieIcon8, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });
        }
    }

    private void setUpUIViews() {
        ivMovieIcon1 = findViewById(R.id.ivIcon1);
        ivMovieIcon2 = findViewById(R.id.ivIcon2);
        ivMovieIcon3 = findViewById(R.id.ivIcon3);
        ivMovieIcon4 = findViewById(R.id.ivIcon4);
        ivMovieIcon5 = findViewById(R.id.ivIcon5);
        ivMovieIcon6 = findViewById(R.id.ivIcon6);
        ivMovieIcon7 = findViewById(R.id.ivIcon7);
        ivMovieIcon8 = findViewById(R.id.ivIcon8);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
