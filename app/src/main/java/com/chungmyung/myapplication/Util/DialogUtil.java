package com.chungmyung.myapplication.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.chungmyung.myapplication.R;

/**
 * Created by user on 2017-07-28.
 */

public class DialogUtil {
    public static AlertDialog  creatAlertDialog(Context context,
                     DialogInterface.OnClickListener listener) {

        //물어보자 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("삭제");
        builder.setMessage("정말로 삭제하시겠습니까 ?");

        //바깥부분 클릭했을때  닫기
        builder.setCancelable(false);
        builder.setIcon(R.drawable.achieve);
        builder.setPositiveButton("예", listener);
        builder.setNegativeButton("아니오", listener);

        return builder.create();
    }
}
