package com.example.qiantao.work;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.qiantao.work.adapter.MainAdapter;
import com.example.qiantao.work.fragment.AlbumFragment;
import com.example.qiantao.work.fragment.AppManagerFragment;
import com.example.qiantao.work.fragment.CalendarFragment;
import com.example.qiantao.work.fragment.FileManagerFragment;
import com.example.qiantao.work.fragment.MusicFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment calendarFragent;
    private Fragment musicFragment;
    private Fragment appManagerFragment;
    private Fragment fileManagerFragment;
    private Fragment albumFragment;

    private MainAdapter adapter;
    private ArrayList<Fragment> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab_layout);

        calendarFragent=new CalendarFragment();
        musicFragment=new MusicFragment();
        appManagerFragment=new AppManagerFragment();
        fileManagerFragment=new FileManagerFragment();
        albumFragment=new AlbumFragment();

        arrayList=new ArrayList<>();
        arrayList.add(albumFragment);
        arrayList.add(calendarFragent);
        arrayList.add(appManagerFragment);
        arrayList.add(fileManagerFragment);
        arrayList.add(musicFragment);

        adapter=new MainAdapter(getSupportFragmentManager(),arrayList);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
