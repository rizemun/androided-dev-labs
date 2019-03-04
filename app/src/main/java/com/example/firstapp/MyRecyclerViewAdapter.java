package com.example.firstapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyRecyclerViewAdapter extends
        RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private List<String> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.my_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("Click", "on item click");
                }
            });
        }
    }

    public MyRecyclerViewAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyRecyclerViewAdapter.MyViewHolder
    onCreateViewHolder(ViewGroup parent,
                       int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String text = mDataset.get(position);
        String text2 = mDataset1.get(position);
        String text3 = mDataset1.get(position);




        holder.mTextView.setText(text);
        holder.mTextView2.setText(text2);
        holder.mTextView3.setText(text3);



        if(text.length() <= 11) {
            holder.mTextView.setTextColor(Color.parseColor("green"));
        }
        else if(text.length() == 12) {
            holder.mTextView.setTextColor(Color.parseColor("blue"));
        }
        else if(text.length() == 13) {
            holder.mTextView.setTextColor(Color.parseColor("red"));
        }
        else if(text.length() == 14) {
            holder.mTextView.setTextColor(Color.parseColor("purple"));
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
