package com.timejh.fragmentcontrol;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private Adapter adapter;

    private ArrayList<String> datas;

    private Listener mListener;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new Adapter(getContext(), mListener);
        adapter.set(datas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onAttach(Context context) { //프래그먼트가 activity에서 호출되는 순간 호출한 activity의 context가 넘어온다
        super.onAttach(context);
        //넘어온 context(Activity)가 OnFragmentInteractionListener의 구현체인지를 확인
        // instanceof : 타입체크
//        if (context instanceof Listener) {
            mListener = (Listener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
        datas = mListener.getData();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface Listener {
        ArrayList<String> getData();
        void goDetail(int position);
    }
}
