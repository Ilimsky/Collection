package de.romantischenoma.oshdigitalb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QRActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        textView = findViewById(R.id.text_view);
        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Model>> gallery = api.galleryContent();
        gallery.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.body() != null && response.isSuccessful()) {
                    textView.append("" + response.body().size());
                    List<Model> models = response.body();
                    Model model = models.get(1);
                    textView.append(model.getDescription() + "\n\n");
                    textView.append(model.getId() + "\n\n");

                } else{
                        textView.append("" + response.code());
                }
            }
            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                textView.append("" + t);
            }
        });
    }
}


