package com.example.tourguide.adapters;

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

import com.example.tourguide.R;
import com.example.tourguide.model.Sight;

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
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        ImageView iv = convertView.findViewById(R.id.iv);
        TextView nameTV = convertView.findViewById(R.id.name_tv);
        TextView descTV = convertView.findViewById(R.id.desc_tv);
        TextView ratingTV = convertView.findViewById(R.id.rating_tv);
        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);

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
        if (position == 0) convertView.setPadding(px, px * 2, px, px);
        else if (position == getCount() - 1) convertView.setPadding(px, px, px, px * 2);

        return convertView;
    }
}