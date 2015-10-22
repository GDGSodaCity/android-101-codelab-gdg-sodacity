package io.github.sodacity.android101;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.github.sodacity.android101.model.Placeholder;
import io.github.sodacity.android101.widget.SquareImageView;

/**
 * Created by r0adkll on 10/21/15.
 */
public class PlaceholderRecyclerAdapter extends RecyclerView.Adapter<PlaceholderRecyclerAdapter.PlaceholderViewHolder> {

    private Activity activity;
    private List<Placeholder> items;

    public PlaceholderRecyclerAdapter(Activity activity){
        this.activity = activity;
        items = new ArrayList<>();
    }

    @Override
    public PlaceholderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_layout_placeholder, parent, false);
        return new PlaceholderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceholderViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, String.format("Item clicked: %d", position), Snackbar.LENGTH_SHORT).show();
            }
        });

        Placeholder item = items.get(position);

        /*
         * Load placeholder image into the holder image with Picasso
         */
        Picasso.with(activity)
                .load(item.getUrl())
                .placeholder(new ColorDrawable(Color.GRAY))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addAll(List<Placeholder> placeholders) {
        items.addAll(placeholders);
    }

    public void add(Placeholder placeholder) {
        items.add(placeholder);
    }

    public void clear() {
        items.clear();
    }

    static class PlaceholderViewHolder extends RecyclerView.ViewHolder{
        SquareImageView image;
        public PlaceholderViewHolder(View itemView) {
            super(itemView);
            image = (SquareImageView) itemView;
        }
    }

}
