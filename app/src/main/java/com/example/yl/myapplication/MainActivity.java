package com.example.yl.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


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

    Runnable runnable = new Runnable() {
      @Override
      public void run() {

        try {

          Thread.sleep(5000);

          mTextView.post(new Runnable() {
            @Override
            public void run() {

              mTextView.setText("AS");
            }
          });

        }
        catch (InterruptedException e) {

          e.printStackTrace();
        }
      }
    };

    Thread thread = new Thread(runnable);

    thread.start();
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
