package com.chungmyung.myapplication.fragment.Basket;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chungmyung.myapplication.R;

/**
 * Created by user on 2017-08-01.
 */

public class BasketScoreFragment extends Fragment implements View.OnClickListener {


    public void warning() {
        getView().setBackgroundColor(Color.RED);
    }


    public interface OnWarningListener { void onWarning(String teamName);   }

    private TextView mScoreTextView;
    private TextView mTeamNameTextView;
    private int mScore;

    private OnWarningListener mListener;  // 인터페이스로 연결됨
    // private BasketBallActivity mAcitivity;  // Class연결되어 않좋음

    // attach를 하는 순간 붙는 context
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 액티비티와 연결된 8월 3일-- fragment 쓰기 위해
        if (context instanceof OnWarningListener){
            mListener= (OnWarningListener) context;
        } else {
            throw new RuntimeException( context.toString()
            + "OnWarningListener를 구현해 주세요");

        }


    //    mActivity = (BasketBallActivity) context; //class로 연결되어 내부적으로 다르게 동작함.

        //직접 사용이 아님 interface로 연결해야 함..엑티비티와 연결됨
         mListener = (OnWarningListener) context;
    }

    //뷰를 만드는 곳
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_basket_ball, container, false);
    }

    // 뷰가 만들어 진 다음 호출되는 곳
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScoreTextView = (TextView) view.findViewById(R.id.score_text);
        mTeamNameTextView = (TextView) view.findViewById(R.id.team_name_text);
        view.findViewById(R.id.button_1).setOnClickListener(this);
        view.findViewById(R.id.button_2).setOnClickListener(this);
        view.findViewById(R.id.button_3).setOnClickListener(this);

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt("score");
            mScoreTextView.setText("" + mScore);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("score", mScore);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                mScore++;
                break;
            case R.id.button_2:
                mScore += 2;
                break;
            case R.id.button_3:
                mScore += 3;
                break;
        }
        if (mScore > 20) {
            mListener.onWarning(mTeamNameTextView.getText().toString());
        }

        mScoreTextView.setText("" + mScore);

    }

    public void reset() {
        mScore = 0;
        mScoreTextView.setText("" + mScore);
    }

    public void setTeamName(String name) {
        mTeamNameTextView.setText(name);
    }




}
