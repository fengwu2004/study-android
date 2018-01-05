package com.example.yl.myapplication;

/**
 * Created by yl on 17-12-12.
 */

public class Book extends Object {

    public String title;

    public String introduce;

    public int picture;

    public Book(String title, int picture, String introduce) {

        super();

        this.title = title;

        this.introduce = introduce;

        this.picture = picture;
    }
}
