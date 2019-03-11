package com.example.luis.sesion6_reciclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Luis on 10/03/2019.
 */

public class ReciclerAdapter extends RecyclerView.Adapter<ReciclerAdapter.ViewHolder>{

    private List<String> names;
    private int layout;
    private OnItemClickListener itemClickListener;

    public ReciclerAdapter(List<String> names, int layout, OnItemClickListener itemClickListener) {
        this.names = names;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(names.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv;

        public ViewHolder(View v){
            super(v);
            this.tv = (TextView) v.findViewById(R.id.tv);
        }

        public void bind(final String name, final OnItemClickListener listener) {
            tv.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(String name, int position);
    }

}
