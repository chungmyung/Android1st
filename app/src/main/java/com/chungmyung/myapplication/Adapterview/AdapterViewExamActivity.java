package com.chungmyung.myapplication.Adapterview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.chungmyung.myapplication.R;
import com.chungmyung.myapplication.Util.SharedPreferenceUtil;
import com.chungmyung.myapplication.fragment.MyAlertDialogFragment;

import java.util.ArrayList;

public class AdapterViewExamActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    private static final String TAG = AdapterViewExamActivity.class.getSimpleName();
    private ArrayList<People> mPeopleData;
    private PeopleAdapter mAdapter;
    private View mListView;
    private EditText mWeatherEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_exam);

        // View
        ListView listView = (ListView) findViewById(R.id.list_view);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Data
        ArrayList<People> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            People people = new People("홍길동" + i, "전화번호 " + i,
                    "이메일" + i, R.drawable.achieve + i);
            data.add(people);
        }

        // Adapter
        PeopleAdapter adapter = new PeopleAdapter(AdapterViewExamActivity.this,
                data);

        listView.setAdapter(adapter);

        gridView.setAdapter(adapter);
        spinner.setAdapter(adapter);

        //OnItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public final String TAG = PeopleAdapter.class.getSimpleName();

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                People people = (People) parent.getAdapter().getItem(position);
                //    Toast.makeText(AdapterViewExamActivity.this, people.toString(),Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onItemClick: " + people.toString()); // debug
                Log.e(TAG, "onItemClick: 에러 ");  // Error
                Log.i(TAG, "onItemClick: 정보");  // information
                Log.w(TAG, "onItemClick: 경고");  // Warning

                Intent intent = new Intent(AdapterViewExamActivity.this, Detail_address_Activity.class);
                intent.putExtra("name", people.getName());
                intent.putExtra("phone", people.getPhone());
                intent.putExtra("email", people.getEmail());
                intent.putExtra("picture", people.getPicture());

                startActivity(intent);
            }
        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdapterViewExamActivity.this, "롱 클릭" + position, Toast.LENGTH_SHORT).show();
//                return true;  // 이벤트 소비 제어.  더이상 이벤트가 흘러가지 않는다. false로 하면 onItemClik이 같이 작동
//            }
//        });

        //Context 메뉴 연결
        registerForContextMenu(mListView);

        String weather = SharedPreferenceUtil.restoreWeather(this);
        // SharedPreference 데이터 복원
//        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
//        String weather = settings.getString("weather", "맑음");

        mWeatherEditText = (EditText) findViewById(R.id.weather_edit);
        mWeatherEditText.setText(weather);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_address, menu);
        Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");

        int id = item.getItemId();

        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(AdapterViewExamActivity.this,
                        Detail_address_Activity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        final AdapterView.AdapterContextMenuInfo info
                = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        switch (item.getItemId()) {
            case R.id.action_item1:
                Toast.makeText(this, "action 1", Toast.LENGTH_SHORT).show();
                showDefaultDialog(info);
                return true;

            case R.id.action_item2:
                Toast.makeText(this, "action 2", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.action_item3:
                Toast.makeText(this, "action 3", Toast.LENGTH_SHORT).show();
                showCustomDialog();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    private void showCustomDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = getLayoutInflater()
                .inflate(R.layout.diallog_signin, null, false);

        builder.setView(view);

        final AlertDialog dialog = builder.create();

        view.findViewById(R.id.positive_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdapterViewExamActivity.this,"잘눌림",Toast.LENGTH_SHORT).show();

                // 다이얼로그 닫기
                dialog.dismiss();
            }
        });

        view.findViewById(R.id.negative_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void showDefaultDialog( final AdapterView.AdapterContextMenuInfo info ) {
        MyAlertDialogFragment fragment =MyAlertDialogFragment.newInstance(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        // 삭제
                        mPeopleData.remove(info.position);
                        // 업데이트
                        mAdapter.notifyDataSetChanged();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        });
        fragment.show(getSupportFragmentManager(),"alert");  // 이전 것은  돌렸을대 내용 지워짐.





//        DialogUtil.creatAlertDialog(this, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which) {
//                    case DialogInterface.BUTTON_POSITIVE:
//                        // 삭제
//                        mPeopleData.remove(info.position);
//                        // 업데이트
//                        mAdapter.notifyDataSetChanged();
//                        break;
//                    case DialogInterface.BUTTON_NEGATIVE:
//                        break;
//                }
//            }
//        }).show();
    }



    @Override
    public void onBackPressed() {
        // 저장
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("weather", mWeatherEditText.getText().toString());

        // Commit the edits!    비동기
        editor.apply();

        // 뒤로 가기
        super.onBackPressed();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                break;
        }
    }
}