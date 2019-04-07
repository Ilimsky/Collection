package com.example.traveldirectory.B;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traveldirectory.Basic.MovieModel;
import com.example.traveldirectory.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {

    //private final String URL_TO_HIT = "https://firebasestorage.googleapis.com/v0/b/aaaaa-ddf65.appspot.com/o/txt%2FBFragment.txt?alt=media&token=421df582-57e6-4c42-af0e-fcebd79277ce";
    private final String URL_TO_HIT = "https://firebasestorage.googleapis.com/v0/b/aaaaa-ddf65.appspot.com/o/JSON%2FjsonHotels.json?alt=media&token=d9376fb4-2a97-4f3a-bb19-809731fbdda0";
    private ListView listView;
    private ProgressDialog dialog;


    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        listView = view.findViewById(R.id.listView);

        // To start fetching the data when app start, uncomment below line to start the async task.
        new JSONTaskB().execute(URL_TO_HIT);
        return view;
    }

    public class JSONTaskB extends AsyncTask<String,String, List<MovieModel> > {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //dialog.show();
        }

        @Override
        protected List<MovieModel> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line ="";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("movies");

                List<MovieModel> movieModelList = new ArrayList<>();

                Gson gson = new Gson();
                for(int i=0; i<parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);
                    /**
                     * below single line of code from Gson saves you from writing the json parsing yourself
                     * which is commented below
                     */
                    MovieModel movieModel = gson.fromJson(finalObject.toString(), MovieModel.class); // a single line json parsing using Gson
                    movieModelList.add(movieModel);
                }
                return movieModelList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null) {
                    connection.disconnect();
                }
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return  null;
        }

        @Override
        protected void onPostExecute(final List<MovieModel> result) {
            super.onPostExecute(result);
            //dialog.dismiss();
            if(result != null) {
                MovieAdapter adapterB = new MovieAdapter(getActivity().getApplicationContext(), R.layout.row, result);
                listView.setAdapter(adapterB);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // list item click opens a new detailed activity
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        MovieModel movieModel = result.get(position); // getting the model
                        Intent intent = new Intent(BFragment.this.getActivity(), BActivity.class);
                        intent.putExtra("movieModel", new Gson().toJson(movieModel)); // converting model json into string type and sending it via intent
                        startActivity(intent);
                    }
                });
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class MovieAdapter extends ArrayAdapter {

        private List<MovieModel> movieModelList;
        private int resource;
        private LayoutInflater inflater;
        public MovieAdapter(Context context, int resource, List<MovieModel> objects) {
            super(context, resource, objects);
            movieModelList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if(convertView == null){
                holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);
                holder.ivMovieIcon = convertView.findViewById(R.id.ivIcon);
                holder.tvMovie = convertView.findViewById(R.id.tvMovie);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            final ProgressBar progressBar = convertView.findViewById(R.id.progressBar);

            // Then later, when you want to display image
            final ViewHolder finalHolder = holder;
            ImageLoader.getInstance().displayImage(movieModelList.get(position).getImage1(), holder.ivMovieIcon, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    progressBar.setVisibility(View.VISIBLE);
                    finalHolder.ivMovieIcon.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    progressBar.setVisibility(View.GONE);
                    finalHolder.ivMovieIcon.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    progressBar.setVisibility(View.GONE);
                    finalHolder.ivMovieIcon.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    progressBar.setVisibility(View.GONE);
                    finalHolder.ivMovieIcon.setVisibility(View.INVISIBLE);
                }
            });

            holder.tvMovie.setText(movieModelList.get(position).getMovie());
            return convertView;
        }


        class ViewHolder{
            public ImageView ivMovieIcon;
            public TextView tvMovie;
        }

    }



}
