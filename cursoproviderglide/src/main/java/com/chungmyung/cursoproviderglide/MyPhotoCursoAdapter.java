package com.chungmyung.cursoproviderglide;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by user on 2017-08-28.
 */

public class MyPhotoCursoAdapter extends CursorAdapter {

    // 인자 autoRequery는 성능이 않좋아  제거하고 사용.  단 super에선 false로 남겨둔다


    public MyPhotoCursoAdapter(Context context, Cursor c, boolean b) {
        super(context, c, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        viewHolder.imageView = view.findViewById(R.id.image_view);
        view.setTag(viewHolder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        // 사진 가져와서 뿌리기 . 그림이 몇번째 옆에 있는지 .   경로 찾아 복붙.
        int index = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
        String data = cursor.getString(index);


//       viewHolder.imageView.setImageURI(Uri.parse(data)); //glide 추가하여 gladle 화일이 하나 생성된 후
        // 끊긴 부분

        Glide.with(context).load(data).into(viewHolder.imageView);
    }

    private static class ViewHolder {
        ImageView imageView;
    }
}
