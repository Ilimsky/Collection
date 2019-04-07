package com.example.traveldirectory.B;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.traveldirectory.Basic.MovieModel;
import com.example.traveldirectory.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class BActivity extends AppCompatActivity {

    private ImageView ivIcon1;
    private ImageView ivIcon2;
    private ImageView ivIcon3;
    private ImageView ivIcon4;
    private ImageView ivIcon5;
    private ImageView ivIcon6;
    private ImageView ivIcon7;
    private ImageView ivIcon8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        /*ImageView ivIcon8 = findViewById(R.id.ivIcon8);

        ivIcon8.setOnClickListener(this);
        arrayList = new ArrayList<>();*/


        /*findViewById(R.id.ivIcon8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), WebActivity.class));
            }
        });*/


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
            ImageLoader.getInstance().displayImage(movieModel.getImage1(), ivIcon1, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage2(), ivIcon2, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage3(), ivIcon3, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage4(), ivIcon4, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage5(), ivIcon5, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage6(), ivIcon6, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage7(), ivIcon7, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {}

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {}

                @Override
                public void onLoadingCancelled(String imageUri, View view) {}
            });

            ImageLoader.getInstance().displayImage(movieModel.getImage8(), ivIcon8, new ImageLoadingListener() {
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
        ivIcon1 = findViewById(R.id.ivIcon1);
        ivIcon2 = findViewById(R.id.ivIcon2);
        ivIcon3 = findViewById(R.id.ivIcon3);
        ivIcon4 = findViewById(R.id.ivIcon4);
        ivIcon5 = findViewById(R.id.ivIcon5);
        ivIcon6 = findViewById(R.id.ivIcon6);
        ivIcon7 = findViewById(R.id.ivIcon7);
        ivIcon8 = findViewById(R.id.ivIcon8);
    }


    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivIcon8:
                String url;
                url = arrayList.get(position).get("URL");
                Intent intent = new Intent(BActivity.this,WebActivity.class);
                intent.putExtra("URL",url);
                startActivity(intent);
                break;
        }
    }*/
}





