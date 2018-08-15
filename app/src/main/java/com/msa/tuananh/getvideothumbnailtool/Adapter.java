package com.msa.tuananh.getvideothumbnailtool;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/*
    17:10 - 15/08/2018
    Tuan Anh dep trai
    hihi
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Video> mList;
    Context mContext;

    public Adapter(List<Video> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        int id = mContext.getResources().getIdentifier(mList.get(position).res, "raw", mContext.getPackageName());

        Glide.with(mContext).load(id).thumbnail(1f).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.saveImage(mList.get(position).res, (Activity) mContext,holder.itemView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.custom_img);
        }
    }
}
