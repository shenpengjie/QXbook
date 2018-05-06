package com.example.spj.qxbook;

/**
 * Created by Asus on 2018/5/6.
 */

public class Book {
    private String  bookname;
    private int imageID;
    public Book(String bookname,int imageID){
        this.bookname=bookname;
        this.imageID=imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public String getBookname() {
        return bookname;
    }
}
