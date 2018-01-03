package com.example.futurist.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdapterChannel extends RecyclerView.Adapter<AdapterChannel.ViewHolder> {
    private static final String TAG = "AdapterChannel";
private String[] mDataset;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    private TextView infoText;
    private FloatingActionButton deleteFab;
    public ViewHolder(View v) {
        super(v);
        infoText = (TextView) v.findViewById(R.id.info_text);
        deleteFab = (FloatingActionButton) v.findViewById(R.id.itemFloatingActionButton);
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterChannel(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterChannel.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_channel, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.infoText.setText(mDataset[position]);



        // Select item
        final int  positionClick = position;
        holder.infoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "select item: " + positionClick);
            }
        });

        // Delete item
        holder.deleteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "delete item: " + positionClick);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}