package com.example.tourguide.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tourguide.R;
import com.example.tourguide.fragments.CopticFragment;
import com.example.tourguide.fragments.IslamicFragment;
import com.example.tourguide.fragments.MuseumFragment;
import com.example.tourguide.fragments.ParkFragment;
import com.example.tourguide.fragments.PharaonicFragment;
import com.example.tourguide.fragments.UnclassifiedFragment;

public class CategoriesFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public CategoriesFragmentAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return position == 0 ? new PharaonicFragment()
                : position == 1 ? new MuseumFragment()
                : position == 2 ? new IslamicFragment()
                : position == 3 ? new CopticFragment()
                : position == 4 ? new ParkFragment()
                : new UnclassifiedFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getStringArray(R.array.titles)[position];
    }
}
