package com.example.futurist.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder> {
    private static final String TAG = "AdapterItem";
    private String[] mDataset;
    private Activity activity;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    private TextView infoTextItem;
    public ViewHolder(View v) {
        super(v);
        infoTextItem = (TextView) v.findViewById(R.id.info_text_item);
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterItem(String[] myDataset, Activity activity) {
        mDataset = myDataset;
        this.activity = activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterItem.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_item, parent, false);
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
        holder.infoTextItem.setText(mDataset[position]);



        // Select item
        final int  positionClick = position;
        holder.infoTextItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "select item: " + positionClick);

                // Start activity Items from channel

                Intent intent = new Intent(activity, ItemInfoActivity.class);
                intent.putExtra(MainActivity.EXTRA_MESSAGE, positionClick);
                activity.startActivity(intent);


            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}