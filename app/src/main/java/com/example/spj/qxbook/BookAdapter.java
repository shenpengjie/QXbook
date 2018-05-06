package com.example.spj.qxbook;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 2018/5/6.
 */

public class BookAdapter extends ArrayAdapter<Book> {
    private int resourceID;

    public BookAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Book book =getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView bookimage=(ImageView) view.findViewById(R.id.book_image);
        TextView bookname=(TextView) view.findViewById(R.id.book_name);
        bookimage.setImageResource(book.getImageID());
        bookname.setText(book.getBookname());
        return view;
    }
}
