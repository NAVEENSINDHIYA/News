package com.example.scindia.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by SCINDIA on 7/10/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    public static final String TAG = "MainActivity";
    Context context;
    ArrayList<BaseNews> arrayList;

    public NewsAdapter(Context context, ArrayList<BaseNews> arrayList) {
        Log.d(TAG, "NewsAdapter: ");
        this.context = context;
        this.arrayList = arrayList;
    }

    public void onUpdateList(ArrayList<BaseNews> arrayList){
            this.arrayList = arrayList;
        Log.d(TAG, "onUpdateList: ");
            notifyDataSetChanged();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item,parent,false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        final BaseNews  newsItem= arrayList.get(position);
        holder.title.setText(newsItem.getTitle());
        holder.desc.setText(newsItem.getDescription());
        holder.time.setText(newsItem.getPublishedAt());
        Picasso.with(context).load(newsItem.getUrlToImage()).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).into(holder.imageView);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(newsItem.getUrl()));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView title,desc,time;
        View rootView;
        ImageView imageView;
        public NewsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            desc = (TextView) itemView.findViewById(R.id.tv_desc);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
            rootView = itemView;
        }
    }
}
