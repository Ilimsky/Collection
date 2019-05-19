package de.romantischenoma.oshdigitala;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class QRAdapter extends RecyclerView.Adapter<QRAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Model> mModel = new ArrayList<>();
    private Context context;

    public QRAdapter(Context context) {

        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setModel(List<Model> model) {
        this.mModel.clear();
        this.mModel.addAll(model);
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycle_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int position) {
        final Model model = mModel.get(position);

        Picasso.get()
                .load(model.getPhoto01())
                .into(viewHolder.imageView);

            /*Picasso.get()
                    .load(model.getPhoto02())
                    .into(viewHolder.imageView2);*/
    }

    @Override
    public int getItemCount() {
        return mModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        /*ImageView imageView2;*/

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv);
        }
    }
}
