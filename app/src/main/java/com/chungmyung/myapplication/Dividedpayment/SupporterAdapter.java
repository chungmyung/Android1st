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

import static com.chungmyung.myapplication.R.layout.position;

/**
 * Created by user on 2017-08-20.
 */

public class SupporterAdapter extends BaseAdapter {

    private final String TAG = SupporterAdapter.class.getSimpleName();
    private final List<Supporter> mData;
    private final Context mContext;


    public SupporterAdapter (Context context, List<Supporter> data){
        mContext = context ;
        mData = data ;
    }


    @Override
    public int getCount() {

        return mData.size();
    }

    @Override
    public Object getItem(int j) {
        return  mData.get(j);
    }

    @Override
    public long getItemId(int j) {
        return j;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holer = null;

        if (view == null) {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.activity_supporterlist_item, viewGroup, false);
            holer = new ViewHolder();

            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
            EditText nameEditText = (EditText) view.findViewById(R.id.name_edit);
            EditText phoneEditText = (EditText) view.findViewById(R.id.phone_edit);
            EditText emailEditText = (EditText) view.findViewById(R.id.email_edit);
            EditText amountEditText = (EditText) view.findViewById(R.id.amount_edit);

            holer.image = imageView;
            holer.name = nameEditText;
            holer.phone = phoneEditText;
            holer.email = emailEditText;
            holer.amount = amountEditText;


            view.setTag(holer);
        } else {
// 재사용
            Log.d(TAG, "getView: 재사용" + position);
            holer = (ViewHolder) view.getTag();
        }
// data
        Attendee attendee = (Attendee) getItem(position);

        holer.name.setText(attendee.getName());
        holer.phone.setText(attendee.getPhone());
        holer.email.setText(attendee.getEmail());
        holer.amount.setText(attendee.getAmount());

        return view;
    }

    private static class ViewHolder {
        ImageView image;
        EditText name;
        EditText phone;
        EditText email;
        EditText amount;
}
    }
