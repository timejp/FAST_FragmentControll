package com.timejh.fragmentcontrol;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ListFragment.Listener, DetailFragment.OnDetailListener {

    String []datas = {"월", "화","수","목","금","토","일"};

    ListFragment listFragment;
    DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFragment = new ListFragment();
        detailFragment = new DetailFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, listFragment);
        transaction.commit();
    }

    @Override
    public ArrayList<String> getData() {
        return new ArrayList<>(Arrays.asList(datas));
    }

    @Override
    public void goDetail(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, detailFragment);
        transaction.commit();
    }

    @Override
    public void goList() {

    }
}
