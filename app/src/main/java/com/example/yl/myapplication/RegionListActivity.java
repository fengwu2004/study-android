package com.example.yl.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yl on 17-12-12.
 */

public class RegionListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listview;

    private List<Book> dataList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_regionlist);

        dataList = new ArrayList();

        for (int i = 0; i < 20; ++i) {

            dataList.add(new Book("学好C++", R.drawable.icon, "深入浅出"));
        }

        listview = findViewById(R.id.listview);

        listview.setAdapter(new MyAdapter(this, dataList));

        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(RegionListActivity.this, "点击" + position + "条数据", Toast.LENGTH_SHORT).show();
    }
}
