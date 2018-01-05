package com.example.yl.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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

    Intent intent = new Intent(MainActivity.this, RegionListActivity.class);

    startActivity(intent);
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
