package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class FilosofiPhoto extends AppCompatActivity {

    ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filosofi_photo);

        mViewPager = findViewById(R.id.pager);
        mViewPager.setAdapter(new ViewPagerAdapter(this));
    }

    public class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @Override
        public Fragment createFragment(int position) {
            if (position == 0) {
                return new FilosofiPhoto1();
            } else {
                return new FilosofiPhoto2();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}