package com.example.recycleview_addremove_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements SearchCat{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    public List<Cat> list=new ArrayList<>();
    public String img,name,cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= findViewById(R.id.viewPage);
        tabLayout= findViewById(R.id.tabLayout2);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentAdapter fragmentAdapter = new FragmentAdapter(fragmentManager,2);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    @Override
    public void getInfor(String info) {

        String[] splits = info.split("-");
        img = splits[0];
        name=splits[1];
        cost=splits[2];
        Log.d("info", img);
        Log.d("info", splits[1]);
        Log.d("info", splits[2]);
        if(Integer.parseInt(img)==0){
            list.add(new Cat(R.drawable.a,name,cost));
        } else if (Integer.parseInt(img)==1) {
            list.add(new Cat(R.drawable.b,name,cost));
        } else  list.add(new Cat(R.drawable.c,name,cost));
    }
}