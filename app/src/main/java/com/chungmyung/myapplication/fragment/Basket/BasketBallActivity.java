package com.chungmyung.myapplication.fragment.Basket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chungmyung.myapplication.R;

public class BasketBallActivity extends AppCompatActivity {

    private BasketScoreFragment mATeamFragment;
    private BasketScoreFragment mBTeamFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_ball);

        mATeamFragment = (BasketScoreFragment)getSupportFragmentManager().findFragmentById(R.id.frag_team_a);
        mBTeamFragment = (BasketScoreFragment)getSupportFragmentManager().findFragmentById(R.id.frag_team_b);

          mATeamFragment.setTeamName("Team A");
          mATeamFragment.setTeamName("Team B");
    }

    public void onResetButtonClicked(View view) {
        mATeamFragment.reset();
        mBTeamFragment.reset();


    }
}
