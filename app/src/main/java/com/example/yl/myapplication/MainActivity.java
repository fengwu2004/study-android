package com.example.yl.myapplication;

import android.icu.text.RelativeDateTimeFormatter;
import android.icu.text.SimpleDateFormat;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TimeUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import java.security.Guard;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.textView) TextView mTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    Toolbar toolbar = findViewById(R.id.toolbar);

    setSupportActionBar(toolbar);

    toolbar.setNavigationIcon(R.drawable.back);
  }

  @OnClick(R.id.button)
  public void onClick(View v) {

    ExecutorService es = Executors.newSingleThreadExecutor();

    CountRunnable work = new CountRunnable();

    Future<Number> future = es.submit(work);

    System.out.println("任务开始于");

    try {

      TimeUnit.SECONDS.sleep(1);

      System.out.println("主线程" + Thread.currentThread().getName() + "依然可以执行");
    }
    catch (InterruptedException e) {

      e.printStackTrace();
    }

    try {

      Number object = future.get();

      System.out.println("任务结束于" + " result="+object.num);
    }
    catch (Exception e) {

      e.printStackTrace();
    }

    es.shutdown();

    System.out.println("任务结束"+es.isShutdown());
  }

  static class Number{

    private int num;

    private int getNum(){

      return num;
    }

    private void setNum(int num){

      this.num = num;
    }
  }

  private class CountRunnable implements Callable<Number> {

    @Override
    public Number call() throws Exception {

      Number number = new Number();

      TimeUnit.SECONDS.sleep(2);

      number.setNum(10);

      return number;
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_main, menu);

    return true;
  }

  public void onComposeClick(MenuItem mi) {

    Log.i("ABC", "onComposeClick");
  }

  public void onProfileClick(MenuItem mi) {

    Log.i("ABC", "onProfileClick");
  }
}
