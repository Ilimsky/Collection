package com.example.traveldirectory.Tours;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.traveldirectory.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToursFragment extends Fragment {

    private ListView listView;

    public ToursFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tours, container, false);

        String data [] = {"Tour number One", "Tour number Two"};
        int pic[] = {R.drawable.logo, R.drawable.logo};

        listView = view.findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(getActivity(),data,pic);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String st = ""+position;
                switch (position){
                    case 0:
                        Intent intent01 = new Intent(ToursFragment.this.getActivity(), MapActivity.class);
                        startActivity(intent01);
                        break;
                    case 1:
                        Intent intent02 = new Intent(ToursFragment.this.getActivity(), Map2Activity.class);
                        startActivity(intent02);
                        break;
                }
            }
        });
            return view;
    }
}
