package com.chungmyung.myapplication.fragment.Sliding;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.chungmyung.myapplication.R;
import com.chungmyung.myapplication.fragment.Basket.BasketScoreFragment;
import com.chungmyung.myapplication.fragment.Color.ColorFragment;
import com.chungmyung.myapplication.fragment.Exam.ChatFragment;

public class SlidingActivity extends AppCompatActivity implements BasketScoreFragment.OnWarningListener,
        ChatFragment.OnSendMessageListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        //최소 유지 page 수
        viewPager.setOffscreenPageLimit(10);

        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onWarning(String teamName) {
        Toast.makeText(this, teamName, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSendMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {

        private static final int PAGE_NUM = 10;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // 화면에 표현해 주는 실제 Fragment
        @Override
        public Fragment getItem(int position) {  // getView와 비슷

            switch (position) {
                case 0:
                    return new BasketScoreFragment();
                case 1:
                    return ColorFragment.newInstance();
                case 2:
                    return new ChatFragment();
            }
            return ColorFragment.newInstance();
        }

        // page 수
        @Override
        public int getCount() {
            return PAGE_NUM;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return "농구";
                case 1 :
                    return "컬러";
                case 2 :
                    return  "Chatting";
            }
            return "등등등";
        }
    }

}
