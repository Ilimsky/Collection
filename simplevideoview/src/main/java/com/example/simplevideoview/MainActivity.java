package com.example.simplevideoview;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVideoView(mVideoView, "http://techslides.com/demos/sample-videos/small.mp4");
    }

    private void setupVideoView(VideoView videoView, String url) {
        videoView = findViewById(R.id.video_view);
        MediaController controls = new MediaController(this);
        controls.setAnchorView(videoView);
        videoView.setMediaController(controls);
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }
}
