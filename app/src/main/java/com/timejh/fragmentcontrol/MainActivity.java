package com.timejh.fragmentcontrol;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListFragment listFragment;
    DetailFragment detailFragment;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = new ListFragment();
        detailFragment = new DetailFragment();

        listFragment.setActivity(this);
        detailFragment.setActivity(this);

        manager = getSupportFragmentManager();

        setList();
    }

    //Activity에 처음 목록이 세팅될때
    public void setList() {
        //1. Transaction 시작
        FragmentTransaction transaction = manager.beginTransaction();
        //2. fragment를 layout 에 add해준다.
        transaction.add(R.id.fragment, listFragment);
        //3. 트랜잭션 전체를 stack에 저장
//        transaction.addToBackStack(null);
        //4. commit
        transaction.commit();
    }

    //Detail 프래그맨트에서 List 로 돌아갈때
    public void backToList() {
//        //1. Transaction 시작
//        FragmentTransaction transaction = manager.beginTransaction();
//        //2. fragment를 layout 에 add해준다.
//        transaction.remove(detailFragment);
//        //3. commit
//        transaction.commit();
        super.onBackPressed();
    }

    //List에서 Detail로 바꿀때(이동할때)
    public void goDetail() {
        //1. Transaction 시작
        FragmentTransaction transaction = manager.beginTransaction();
        //2. fragment를 layout 에 add해준다.
        transaction.add(R.id.fragment, detailFragment);
        //3. 트랜잭션 전체를 stack에 저장
        transaction.addToBackStack(null);
        //4. commit
        transaction.commit();
    }
}
