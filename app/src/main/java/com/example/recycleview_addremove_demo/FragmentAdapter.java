package com.example.recycleview_addremove_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 : return  new InputFragment();
            case 1 : return  new SearchFragment();
            case 2 : return  new CalFragment();
            default:return new InputFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0 : return  "Nhap/Xoa" ;
            case 1 : return  "Tim Kiem" ;
            case 2 : return "Tinh toan";
            default:return "Nhap/Xoa" ;
        }
    }
}
