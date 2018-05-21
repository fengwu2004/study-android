package com.example.yl.myapplication;

import android.content.Intent;
import android.icu.text.RelativeDateTimeFormatter;
import android.icu.text.SimpleDateFormat;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.INotificationSideChannel;
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


import com.itgoyo.logtofilelibrary.LogToFileUtils;

import java.security.Guard;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.textView) TextView mTextView;

  FutureTask<Number> futureTask;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    Toolbar toolbar = findViewById(R.id.toolbar);

    setSupportActionBar(toolbar);

    toolbar.setNavigationIcon(R.drawable.back);

    LogToFileUtils.init(this); //初始化

    LogToFileUtils.write("sample text");//写入日志
  }

  private void test() {

    CountRunnable work = new CountRunnable();

    futureTask = new FutureTask<Number>(work) {

      @Override
      protected void done() {
        try {

          Number number = futureTask.get();

          Log.d("ABCD", Thread.currentThread().getName());
        }
        catch (InterruptedException e) {

          e.printStackTrace();
        }
        catch (ExecutionException e) {

          e.printStackTrace();
        }
        catch (CancellationException e) {

        }
      }
    };

    ExecutorService es = Executors.newFixedThreadPool(2);

    es.execute(futureTask);

    System.out.println("任务结束" + es.isShutdown());
  }

  @OnClick(R.id.button)
  public void onClick(View v) {

    Intent intent = new Intent();

    intent.setClass(MainActivity.this, MapActivity.class);

    startActivity(intent);
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

      TimeUnit.SECONDS.sleep(10);

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
