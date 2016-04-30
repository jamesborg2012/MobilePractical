package com.example.james.mobilepractical;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by James on 27/04/2016.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter
{
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Sports", "Technology", "Food" };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Example getItem(int position) {
        return Example.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
