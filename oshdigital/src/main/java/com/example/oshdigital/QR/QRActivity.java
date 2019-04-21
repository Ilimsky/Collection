package com.example.oshdigital.QR;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.oshdigital.Basic.MainActivity;
import com.example.oshdigital.R;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QRActivity extends AppCompatActivity {

    MediaPlayer player;
    private String urlAudio;

    private String qrResult;
    private int qrCode;
    TextView textFromApi;
    TextView textViewQR;

    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    QRAdapter qrAdapter;

    VideoView videoView;

    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        loadData();
        initRecyclerView();

        textFromApi = findViewById(R.id.text_from_api);
        textViewQR = findViewById(R.id.text_view_qrcode);

        Bundle args = getIntent().getExtras();
        qrResult = args.getString("qr_result");
        qrCode = Integer.parseInt(qrResult);

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QRActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void loadData() {

        final MediaController mediaController = new MediaController(this);

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Model>> gallery = api.galleryContent(qrCode);
        gallery.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                if (response.body() != null && response.isSuccessful()) {
                    Log.i("test", "onResponse: " + response.body().size());
                    qrAdapter.setModel(response.body());

                    textFromApi.setMovementMethod(new ScrollingMovementMethod());

                    List<Model> models = response.body();
                    Model model = models.get(qrCode);

                    //for (Model model : models) {
                    //textFromApi.append(model.getId() + "\n");
                    //textFromApi.append(model.getPhoto01() + "\n");
                    //textFromApi.append(model.getPhoto02() + "\n");
                    textFromApi.append(model.getDescription() + "\n\n");
                    //textFromApi.append(model.getAudio()+"\n");
                    urlAudio = model.getAudio();
                    textViewQR.append(model.getName());
                    //}

                    String urlVideo = model.getVideo();
                    videoView = findViewById(R.id.video_view);

                    mediaController.setAnchorView(videoView);
                    videoView.setMediaController(mediaController);
                    videoView.setVideoURI(Uri.parse(urlVideo));

                } else {
                    try {
                        Log.e(TAG, "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i("tes2", "onFailure: " + t);
            }
        });

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        qrAdapter = new QRAdapter(this);
        recyclerView.setAdapter(qrAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, Uri.parse(this.urlAudio));
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}


