package com.chungmyung.myapplication.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import com.chungmyung.myapplication.R;

/**
 * Created by user on 2017-08-14.
 */

public class MyAlertDialogFragment extends DialogFragment {
    private DialogInterface.OnClickListener mListener;
    private static final String TAG = MyAlertDialogFragment.class.getSimpleName();


    public static MyAlertDialogFragment newInstance(DialogInterface.OnClickListener listener) {

        Bundle args = new Bundle();

        MyAlertDialogFragment fragment = new MyAlertDialogFragment();
        fragment.setArguments(args);
        fragment.setPositiveButtonClickListener(listener);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        Log.d(TAG, "onCreateDialog:");

        //물어보자 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("삭제");
        builder.setMessage("정말로 삭제하시겠습니까 ?");

        //바깥부분 클릭했을때  닫기
        builder.setCancelable(false);
        builder.setIcon(R.drawable.achieve);

        builder.setPositiveButton("예", mListener);


        builder.setNegativeButton("아니오", null);

        return builder.create();
    }

    public void setPositiveButtonClickListener(DialogInterface.OnClickListener listener) {
        Log.d(TAG, "setPositiveButtonClickListener:");
        mListener = listener;
    }

}
