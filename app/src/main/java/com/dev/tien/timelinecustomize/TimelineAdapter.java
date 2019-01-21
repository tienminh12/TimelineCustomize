package com.dev.tien.timelinecustomize;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

public class TimelineAdapter  extends RecyclerView.Adapter<TimelineAdapter.ViewHolder>{

    private static final int VIEW_TYPE_MIDDLE = 1;
    private static final int VIEW_TYPE_BOTTOM = 2;

    private Context context;
//    private List<Item> items;

    public TimelineAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_timeline, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
//        Item item = mItems.get(position);
        // Populate views...
        // other here
        switch(holder.getItemViewType()) {
            case VIEW_TYPE_MIDDLE:
                // Only the color could be enough
                holder.mItemLine.setBackgroundColor(Color.RED);
                break;
            case VIEW_TYPE_BOTTOM:
                holder.mItemLine.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount() - 1) {
            return VIEW_TYPE_BOTTOM;
        }
        return VIEW_TYPE_MIDDLE;
    }

    @Override
    public int getItemCount() {
        return 10; // set default for test
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mItemTitle;
        TextView mItemSubtitle;
        View mItemLine;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemTitle = itemView.findViewById(R.id.item_title);
            mItemSubtitle = itemView.findViewById(R.id.item_subtitle);
            mItemLine = itemView.findViewById(R.id.item_line);
        }
    }
}
