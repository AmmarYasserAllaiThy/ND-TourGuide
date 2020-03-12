package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SightsArrayAdapter extends ArrayAdapter<Sight> {

    private Context context;

    public SightsArrayAdapter(@NonNull Context context, @NonNull ArrayList<Sight> sights) {
        super(context, 0, sights);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null)
            itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        ImageView iv = itemView.findViewById(R.id.iv);
        TextView nameTV = itemView.findViewById(R.id.name_tv);
        TextView descTV = itemView.findViewById(R.id.desc_tv);
        TextView ratingTV = itemView.findViewById(R.id.rating_tv);
        RatingBar ratingBar = itemView.findViewById(R.id.ratingBar);

        Sight sight = getItem(position);
        if (sight != null) {
            int imageResId = sight.getImageResId();
            if (imageResId != -1) iv.setImageResource(imageResId);
            nameTV.setText(sight.getName());
            descTV.setText(sight.getDesc());
            ratingTV.setText(String.valueOf(sight.getRate()));
            ratingBar.setRating(sight.getRate());
        }

        /*
           Adjust padding for first and last item
         */
        int px = (int) context.getResources().getDimension(R.dimen.list_padding);
        if (position == 0) itemView.setPadding(px, px * 2, px, px);
        else if (position == getCount() - 1) itemView.setPadding(px, px, px, px * 2);

        return itemView;
    }
}