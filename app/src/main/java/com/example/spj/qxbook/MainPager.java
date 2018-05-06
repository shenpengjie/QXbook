package com.example.spj.qxbook;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2018/5/6.
 */

public class MainPager extends Activity {
    private List<Book> bookList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpager);
        initFruits();
        BookAdapter adapter=new BookAdapter(MainPager.this,R.layout.book_item,bookList);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initFruits(){
        Book Chinese=new Book("Book",R.mipmap.ic_launcher);
        bookList.add(Chinese);
        Book Math=new Book("Math",R.mipmap.ic_launcher);
        bookList.add(Math);
        Book History=new Book("History",R.mipmap.ic_launcher);
        bookList.add(History);
        Book English=new Book("English",R.mipmap.ic_launcher);
        bookList.add(English);
        Book Mayuan=new Book("Mayuan",R.mipmap.ic_launcher);
        bookList.add(Mayuan);

    }
}
