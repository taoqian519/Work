package com.example.qiantao.work.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayList;

    public MainAdapter(FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        this.arrayList=arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        if(arrayList!=null){
            return arrayList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }
}
