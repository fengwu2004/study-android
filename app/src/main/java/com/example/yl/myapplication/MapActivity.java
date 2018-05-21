package com.example.yl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MapActivity extends AppCompatActivity {

  private WebView mapview;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_map_view);

    mapview = findViewById(R.id.mapview);

    mapview.getSettings().setJavaScriptEnabled(true);

    mapview.loadUrl("https://get.webgl.org/");
  }
}
