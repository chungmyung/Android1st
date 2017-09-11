package com.chungmyung.myapplication.Dividedpayment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.chungmyung.myapplication.R;

import java.util.List;

/**
 * Created by user on 2017-08-16.
 */

public abstract class AttendeeAdapter extends BaseAdapter {

    private final String TAG = AttendeeAdapter.class.getSimpleName();
    private final List<Attendee> mData;
    private final Context mContext;

    public AttendeeAdapter(Context context, List<Attendee> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    // DB 활용.
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holer = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.activity_attendee_list, parent, false);
            holer = new ViewHolder();

            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
            EditText nameEditText = (EditText) convertView.findViewById(R.id.name_edit);
            EditText phoneEditText = (EditText) convertView.findViewById(R.id.phone_edit);
            EditText emailEditText = (EditText) convertView.findViewById(R.id.email_edit);
            EditText amountEditText = (EditText) convertView.findViewById(R.id.amount_edit);

            holer.image = imageView;
            holer.name = nameEditText;
            holer.phone = phoneEditText;
            holer.email = emailEditText;
            holer.amount = amountEditText;


            convertView.setTag(holer);
        } else {
// 재사용
            Log.d(TAG, "getView: 재사용" + position);
            holer = (ViewHolder) convertView.getTag();
        }
// data
        Attendee attendee = (Attendee) getItem(position);

        holer.name.setText(attendee.getName());
        holer.phone.setText(attendee.getPhone());
        holer.email.setText(attendee.getEmail());
        holer.amount.setText(attendee.getAmount());

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        EditText name;
        EditText phone;
        EditText email;
        EditText amount;
    }

}
