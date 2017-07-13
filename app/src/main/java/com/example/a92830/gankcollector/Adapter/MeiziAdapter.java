package com.example.a92830.gankcollector.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a92830.gankcollector.Activity.PictureActivity;
import com.example.a92830.gankcollector.R;
import com.example.a92830.gankcollector.config.MyApplication;
import com.example.a92830.gankcollector.db.Meizi;

import java.util.List;


public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.ViewHolder> {
    List<Meizi> urls;
    private static final String TAG = "MeiziAdapter";

    public MeiziAdapter(List<Meizi> urls) {
        this.urls = urls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meizi_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getLayoutPosition();
                Intent intent = new Intent(view.getContext(), PictureActivity.class);
                intent.putExtra("url", urls.get(position).getUrl());
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) view.getContext(), holder.imageView, "1");
                ActivityCompat.startActivity(view.getContext(), intent, activityOptionsCompat.toBundle());
            }}
        );
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String url = urls.get(position).getUrl();
        Glide.with(MyApplication.getContext()).load(url).placeholder(R.drawable.placeholder).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;

        public ViewHolder(final View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.meizi_image);
        }
    }
}