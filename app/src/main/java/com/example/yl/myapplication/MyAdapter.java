package com.example.yl.myapplication;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedOutputStream;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by yl on 17-12-12.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;

    private List<Book> books;

    private LayoutInflater layoutInflater;

    private ImageView bookicon;

    private TextView title;

    private TextView introduce;

    MyAdapter(Context context, List<Book> books) {

        this.context = context;

        this.books = books;

        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {

        return books.size();
    }

    @Override
    public Object getItem(int position) {

        return books.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.layout, null);
        }

        bookicon = convertView.findViewById(R.id.imageView);

        title = convertView.findViewById(R.id.title);

        introduce = convertView.findViewById(R.id.introduce);

        Book book = books.get(position);

        bookicon.setBackgroundResource(book.picture);

        title.setText(book.title);

        introduce.setText(book.introduce);

        return convertView;
    }
}
