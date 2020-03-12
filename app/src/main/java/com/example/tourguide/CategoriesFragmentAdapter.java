package com.example.tourguide;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
