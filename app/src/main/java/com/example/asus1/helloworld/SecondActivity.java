package com.example.asus1.helloworld;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.behaviour.BottomNavBarFabBehaviour;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.asus1.helloworld.fragment.*;

public class SecondActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);

        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        /* the setting for BottomNavigationBar */

//        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar.setBarBackgroundColor(R.color.white);//set background color for navigation bar
        mBottomNavigationBar.setInActiveColor(R.color.gray);//unSelected icon color
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_temp, R.string.tab_one).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.icon_statistic, R.string.tab_two).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.icon_setting, R.string.tab_three).setActiveColorResource(R.color.blue))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mFragmentOne = FragmentOne.newInstance("First Fragment");
        transaction.replace(R.id.ll_content, mFragmentOne).commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne = FragmentOne.newInstance("First Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = FragmentTwo.newInstance("Second Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentTwo);
                break;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = FragmentThree.newInstance("Third Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentThree);
                break;
            default:
                if (mFragmentOne == null) {
                    mFragmentOne = FragmentOne.newInstance("First Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

}
