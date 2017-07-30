package com.chungmyung.myapplication.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 2017-07-31.
 */

public class SharedPreferenceUtil {
    public static void saveWeather (Context context, String weather){
        // 저장
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("weather",weather);

        // Commit the edits!    비동기
        editor.apply();

        // 뒤로 가기
        editor.apply();
    }
    public static String restoreWeather (Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);

        return settings.getString("weather", "맑음") ;
    }
}
