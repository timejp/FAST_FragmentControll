package com.timejh.fragmentcontrol;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tokijh on 2017. 2. 1..
 */

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    private final String TAG = "Adapter";

    ArrayList<String> datas;
    Context context;
    ListFragment.Listener listener;

    public Adapter(Context context, ListFragment.Listener listener) {
        datas = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    public void add(String data) {
        datas.add(data);
        this.notifyDataSetChanged();
    }

    public void set(ArrayList<String> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final String data = datas.get(position);

        holder.tv_title.setText(data);
        holder.position = position;

        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        holder.cardView.setAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title;
        CardView cardView;

        int position;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.goDetail(position);
                }
            });
        }
    }
}