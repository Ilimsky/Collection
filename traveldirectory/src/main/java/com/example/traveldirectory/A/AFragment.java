package com.example.traveldirectory.A;


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
public class AFragment extends Fragment {

    /*ArrayList<Sanatorium> sanatoriumList;
    SanatoriumAdapter sanatoriumAdapter;*/

    //private final String URL_TO_HIT = "https://firebasestorage.googleapis.com/v0/b/aaaaa-ddf65.appspot.com/o/JSON%2FjsonSanatoriums.json?alt=media&token=870d4750-b456-4310-9921-3079690f74b8";
    private final String URL_TO_HIT = "https://firebasestorage.googleapis.com/v0/b/aaaaa-ddf65.appspot.com/o/JSON%2FjsonSanatoriums.json?alt=media&token=7458eb4f-0a48-4070-ba62-bf3e192e689a";
    private ListView listView;
    private ProgressDialog dialog;

    public AFragment() {
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
        new AFragment.JSONTaskB().execute(URL_TO_HIT);
        return view;
    }

    public class JSONTaskB extends AsyncTask<String,String, List<MovieModel>> {

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
                AFragment.MovieAdapter adapterB = new AFragment.MovieAdapter(getActivity().getApplicationContext(), R.layout.row, result);
                listView.setAdapter(adapterB);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // list item click opens a new detailed activity
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        MovieModel movieModel = result.get(position); // getting the model
                        Intent intent = new Intent(AFragment.this.getActivity(), AActivity.class);
                        intent.putExtra("movieModel", new Gson().toJson(movieModel)); // converting model json into string type and sending it via intent
                        startActivity(intent);
                    }
                });
            } else {
                Toast.makeText(getContext().getApplicationContext(), "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
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

            AFragment.MovieAdapter.ViewHolder holder = null;

            if(convertView == null){
                holder = new AFragment.MovieAdapter.ViewHolder();
                convertView = inflater.inflate(resource, null);
                holder.ivMovieIcon = convertView.findViewById(R.id.ivIcon);
                holder.tvMovie = convertView.findViewById(R.id.tvMovie);
                convertView.setTag(holder);
            } else {
                holder = (AFragment.MovieAdapter.ViewHolder) convertView.getTag();
            }

            final ProgressBar progressBar = convertView.findViewById(R.id.progressBar);

            // Then later, when you want to display image
            final AFragment.MovieAdapter.ViewHolder finalHolder = holder;
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



    /////////////////////////////////////////////////////////////////////////////////
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        sanatoriumList = new ArrayList<Sanatorium>();
        new JSONAsyncTask().execute("https://firebasestorage.googleapis.com/v0/b/aaaaa-ddf65.appspot.com/o/JSON%2FjsonSanatoriums.json?alt=media&token=870d4750-b456-4310-9921-3079690f74b8");

        ListView listview = view.findViewById(R.id.list);
        sanatoriumAdapter = new SanatoriumAdapter(getActivity(), R.layout.row_sanatorium, sanatoriumList);

        listview.setAdapter(sanatoriumAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), sanatoriumList.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
                dialog = new ProgressDialog(AFragment.this.getActivity());
                dialog.setMessage("Loading, please wait");
                dialog.setTitle("Connecting server");
                dialog.show();
                dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONArray("actors");

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        Sanatorium actor = new Sanatorium();

                        actor.setDescription(object.getString("description"));
                        actor.setImage(object.getString("image"));
                        actor.setImage2(object.getString("image2"));
                        actor.setImage3(object.getString("image3"));
                        actor.setImage4(object.getString("image4"));
                        actor.setImage5(object.getString("image5"));
                        actor.setImage6(object.getString("image6"));
                        actor.setImage7(object.getString("image7"));

                        sanatoriumList.add(actor);
                    }
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            sanatoriumAdapter.notifyDataSetChanged();
            if (result == false)
                Toast.makeText(getActivity(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

        }
    }*/
}


