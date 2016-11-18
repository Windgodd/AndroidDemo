package com.demo.android.tabhostdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost tabHost = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this,getSupportFragmentManager(),R.id.fl_fragment_replace);

        tabHost.addTab(tabHost.newTabSpec("0").setIndicator(getTabView("home")),HomeFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("1").setIndicator(getTabView("hello")),HelloFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("2").setIndicator(getTabView("content")),ContentFragment.class,null);

    }

    private View getTabView(String title){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.tab_item_layout,null);
        ((TextView) view.findViewById(R.id.tv_tabname)).setText(title);
        return view;
    }
}
