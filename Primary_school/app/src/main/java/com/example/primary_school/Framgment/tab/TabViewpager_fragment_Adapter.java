package com.example.primary_school.Framgment.tab;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class TabViewpager_fragment_Adapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> tabtitles;
    public TabViewpager_fragment_Adapter(@NonNull FragmentManager fm, List<Fragment> fragments,List<String> tabtitles) {
        super(fm);
        this.fragmentList=fragments;
        this.tabtitles = tabtitles;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        Log.e("TabViewpager_fragment_Adapter, ","getItemPosition: "+object);
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.e("Fragment getItem, ","getItem: "+position);
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
