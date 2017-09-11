package com.chungmyung.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.chungmyung.myapplication.Adapterview.AdapterViewExamActivity;
import com.chungmyung.myapplication.Flexiable_UI.NewsActivity;
import com.chungmyung.myapplication.fragment.Basket.BasketBallActivity;
import com.chungmyung.myapplication.fragment.Color.ColorActivity;
import com.chungmyung.myapplication.fragment.Exam.CallbackExamActivity;
import com.chungmyung.myapplication.fragment.Exam.ExamColorActivity;
import com.chungmyung.myapplication.fragment.Sliding.SlidingActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;


public class MainActivity extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String CLASS = "class";

    private List<Map<String, Object>> mDataList;
    private SimpleAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Data

        mDataList = new ArrayList<>();

        addItem("커피 앱", "Activity 의 기본, 암시적 인텐트, 옵션 메뉴,리소스 분기", CoffeeActivity.class);
        addItem("농구 점수 계산", "상태 저장", BasketBallActivity.class);
        addItem("화면 이동 예제", "데이터 주거니 받거니", ActivityMoveActivity.class);
        addItem("로그인", "데이터 주거니 받거니 복습", LoginActivity.class);
        addItem("암시적 인텐트", "웹 브라우저, 전화 걸기, 텍스트 전송", ImplicitIntentActivity.class);
        addItem("WebView", "WebView, 뒤로 가기 재정의, ", WebViewActivity.class);
        addItem("회원가입", "RadioGroup", SignUpActivity.class);
        addItem("AdapterView", "ArrayAdapter, 모델클래스 작성, BaseAdapter, ViewHolder패턴, 아이템 클릭 리스너, Log, 롱클릭 리스너, 옵션 메뉴, Context 메뉴, 어댑터 변경 통지, SharedPreference, AlertDialog, CustomDialog, 리팩토링", AdapterViewExamActivity.class);
        addItem("생명 주기", "Activity Life cycle", LifeCycleActivity.class);
        addItem("상태 저장", "onSaveInstanceState, onRestoreInstanceState", LifeCycleActivity.class);
        addItem("농구 앱 프래그먼트 버전", "Fragment, Callback", com.chungmyung.myapplication.fragment.Basket.BasketBallActivity.class);
        addItem("프래그먼트 동적 생성", "코드로 Fragment 생성, 리소스 분기", ColorActivity.class);
        addItem("과제 : 컬러 프래그먼트", "프래그먼트 추가, 제거", ExamColorActivity.class);
        addItem("과제 : 콜백", "액티비티와 프래그먼트 통신", CallbackExamActivity.class);
        addItem("좌우로 슬라이딩", "ViewPager", SlidingActivity.class);
        addItem("유연한 UI 구성 ", "ListFragment", NewsActivity.class);

        // 순서 뒤집기
        Collections.reverse(mDataList);


        // Adapter

        mAdapter = new SimpleAdapter(this,
                mDataList,
                android.R.layout.simple_list_item_2,
                new String[]{TITLE, DESCRIPTION},
                new int[]{android.R.id.text1, android.R.id.text2});

        //View
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class cls = (Class) mDataList.get(position).get(CLASS);
                Intent intent = new Intent(MainActivity.this, cls);
                startActivity(intent);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Class cls = (Class) mDataList.get(position).get(CLASS);
                Toast.makeText(MainActivity.this, cls.getName(), Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }

    private void addItem(String title, String description, Class cls) {
        Map<String, Object> data = new HashMap<>();
        data.put(TITLE, title);
        data.put(DESCRIPTION, description);
        data.put(CLASS, cls);

        mDataList.add(data);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.action_sort) {
//            Collections.reverse(mDataList);
//            mAdapter.notifyDataSetChanged();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
