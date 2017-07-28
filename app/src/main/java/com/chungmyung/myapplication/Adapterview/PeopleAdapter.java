package com.chungmyung.myapplication.Adapterview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chungmyung.myapplication.R;

import java.util.List;

/**
 * Created by user on 2017. 7. 26..
 */

public class PeopleAdapter extends BaseAdapter {

    private final String TAG = PeopleAdapter.class.getSimpleName();
    private final List<People> mData;
    private final Context mContext;

    public PeopleAdapter(Context context, List<People> data) {
        mContext = context;
        mData = data;
    }

    // 데이터 갯수
    @Override
    public int getCount() {
        return mData.size();
    }

    // position번째에 어떤 데이터가 있는지 알려줘야 함
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // 데이터베이스의 id
    @Override
    public long getItemId(int position) {
        return position;
    }

    // position번째의 레이아웃 완성 해서 알려줘야 함
// convertView - position번째의 레이아웃의 레퍼런스
// parent - 이 어댑터가 붙을 부모의 레퍼런스 (ListView나 GridView)

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
// 최초
            Log.d(TAG, "getView: 최초 " + position);
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_exam, parent, false);
            holder = new ViewHolder();

// 레이아웃 가지고 오기
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
            TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text);
            TextView phoneTextView = (TextView) convertView.findViewById(R.id.phone_text);
            TextView emailTextView = (TextView) convertView.findViewById(R.id.email_text);
            holder.image = imageView;
            holder.name = nameTextView;
            holder.phone = phoneTextView;
            holder.email = emailTextView;


            convertView.setTag(holder);
        } else {
// 재사용
            Log.d(TAG, "getView: 재사용" + position);
            holder = (ViewHolder) convertView.getTag();
        }

// data
        People people = (People) getItem(position);

// 뿌리기
        int picture;
        if (position % 2 == 0) {
            picture = R.drawable.achieve;
        } else {
            picture = R.mipmap.ic_launcher;
        }
        people.setPicture(picture);
        // 배경색 주기
// convertView.setBackgroundColor(Color.GRAY);
        holder.image.setImageResource(picture);
        holder.name.setText(people.getName());
        holder.phone.setText(people.getPhone());
        holder.email.setText(people.getPhone());

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
        TextView email;
    }

}