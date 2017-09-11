package com.chungmyung.myapplication.fragment.Color;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chungmyung.myapplication.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    // 프래그먼트는 반드시 빈 생성자 만 있어야 한다.!!!
    public ColorFragment() {
        // Required empty public constructor
    }

    // Design pattern 중에서는 new Instance 생성하여 factory method를 만들어 주는 기능이 있다.
    public static ColorFragment newInstance(int color) {

        Bundle args = new Bundle();
        args.putInt("color", color);

        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static ColorFragment newInstance() {

        Bundle args = new Bundle();
        int r = new Random().nextInt(256);
        int g = new Random().nextInt(256);
        int b = new Random().nextInt(256);
        int color = Color.argb(255, r, g, b);
        args.putInt("color", color);

        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//   new Instance기능으로 못쓰게 된 코딩.
//        int r = new Random().nextInt(256);
//        int g = new Random().nextInt(256);
//        int b = new Random().nextInt(256);
//        int activity_color = Color.argb(255, r, g, b);

        // Acitivity에서 넘긴 것을  받을땐 getArgument로 받는다.
        int color = getArguments().getInt("color");
        view.setBackgroundColor(color);
    }
//     //외부에서 색깔을 정하는 메소드.
//    허나 위쪽 newInstance()   ; factory design pattern 생성으로
//    동적사용이 가능해져서 필요 없는 code가 됨.
//    public void setColor(int color) {
//        getView().setBackgroundColor(color);
//    }

}
