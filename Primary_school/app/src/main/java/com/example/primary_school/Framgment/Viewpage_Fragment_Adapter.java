package com.example.primary_school.Framgment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class Viewpage_Fragment_Adapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public Viewpage_Fragment_Adapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.list=fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }


    @Override
    public int getCount() {
        return list.size();
    }
}
