package com.example.tourguide;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new CategoriesFragmentAdapter(this, getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_info) new AlertDialog.Builder(this)
                .setMessage("All these sights info, images, and ratings are copied from Google (Top things to do in Cairo)")
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .create()
                .show();

        return super.onOptionsItemSelected(item);
    }
}