package com.example.traveldirectory.News;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.traveldirectory.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    public NewsFragment() {
        // Required empty public constructor
    }

    private WebView webView;
    private String url = "https://www.reddit.com/r/Kyrgyzstan/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        webView = view.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(url);
        return view;
    }
}