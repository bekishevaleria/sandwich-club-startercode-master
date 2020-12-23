package com.udacity.sandwichclub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.udacity.sandwichclub.model.Sandwich;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter <RVAdapter.ViewHolder> {
    private final MainActivity mainActivity;
    private final String[] values;

    RVAdapter(MainActivity parent, String[] items) {
        mainActivity = parent;
        values = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.idView.setText(values[position]);
        holder.itemView.setTag(new Integer (position));
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() { return values.length; }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idView;

        ViewHolder(View view) {
            super(view);
            idView = view.findViewById(R.id.tx);

        }
    }
    final private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int item = (int) view.getTag();
            Context context = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_POSITION, item);
            context.startActivity(intent);
        }
    };


}
