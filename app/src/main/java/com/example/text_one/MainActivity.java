package com.example.text_one;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.text_one.adapter.FragmentAdapter;
import com.example.text_one.fragment.ContactFragment;
import com.example.text_one.fragment.DynamicFragment;
import com.example.text_one.fragment.MessageFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mViewpager;
    private TabLayout mTab;
    private NavigationView mNav;
    private DrawerLayout mDl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initCall();
    }

    private void initCall() {
        mToolbar.setTitle("我的");
        setSupportActionBar(mToolbar);

       ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
               mDl, mToolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        mDl.addDrawerListener(toggle);


        ArrayList<Fragment> frg = new ArrayList<>();
        frg.add(new MessageFragment());
        frg.add(new DynamicFragment());
        frg.add(new ContactFragment());

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), frg);
        mViewpager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewpager);
        mTab.getTabAt(0).setText("消息").setIcon(R.drawable.bar_home_normal);
        mTab.getTabAt(1).setText("联系人").setIcon(R.drawable.bar_class_normal);
        mTab.getTabAt(2).setText("动态").setIcon(R.drawable.bar_more_normal);
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTab = (TabLayout) findViewById(R.id.tab);
        mNav = (NavigationView) findViewById(R.id.nav);
        mDl = (DrawerLayout) findViewById(R.id.dl);
    }


}
