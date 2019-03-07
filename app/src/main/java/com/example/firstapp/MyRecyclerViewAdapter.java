package com.example.firstapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyRecyclerViewAdapter extends
        RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private List<String> mDataset;
    private List<String> countries;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public TextView mCountryView;
        public ImageView mFlagView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.my_text_view);
            mCountryView = v.findViewById(R.id.country);
            mFlagView = v.findViewById(R.id.flag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("Click", "on item click");
                }
            });
        }
    }

    public MyRecyclerViewAdapter(List<String> myDataset, List<String> myCountriesSet) {
        mDataset = myDataset;
        countries = myCountriesSet;
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
        String countryText = countries.get(position);


        holder.mTextView.setText(text);
        holder.mCountryView.setText(countryText);


        switch (countryText) {
            case "Россия":
                holder.mFlagView.setImageResource(R.drawable.russia);
                break;
            case "Франция":
                holder.mFlagView.setImageResource(R.drawable.france);
                break;
            case "США":
                holder.mFlagView.setImageResource(R.drawable.usa);
                break;
        }


        if (text.length() >= 1 && text.length() <= 5) {
            holder.mTextView.setTextColor(Color.parseColor("blue"));
        } else if (text.length() >= 6 && text.length() <= 7) {
            holder.mTextView.setTextColor(Color.parseColor("red"));
        } else if (text.length() > 7) {
            holder.mTextView.setTextColor(Color.parseColor("#2F674E"));
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
