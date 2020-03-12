package com.example.tourguide.fragments;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.tourguide.R;
import com.example.tourguide.model.Sight;
import com.example.tourguide.adapters.SightsArrayAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnclassifiedFragment extends Fragment {

    public UnclassifiedFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        ArrayList<Sight> sights = new ArrayList<>();
        TypedArray categoryTypedArray = getResources().obtainTypedArray(R.array.unclassified);

        for (int i = 0; i < categoryTypedArray.length(); i++) {
            int siteResId = categoryTypedArray.getResourceId(i, -1);
            if (siteResId < 0) continue;

            TypedArray siteTypedArray = getResources().obtainTypedArray(siteResId);
            sights.add(new Sight(
                    siteTypedArray.getResourceId(0, -1),
                    siteTypedArray.getString(1),
                    siteTypedArray.getString(2),
                    siteTypedArray.getFloat(3, 0.0f)
            ));
        }

        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(new SightsArrayAdapter(getContext(), sights));

        return rootView;
    }
}