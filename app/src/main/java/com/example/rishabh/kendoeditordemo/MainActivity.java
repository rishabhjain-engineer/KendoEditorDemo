package com.example.rishabh.kendoeditordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView mwebView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mwebView = (WebView) findViewById(R.id.htmlView);

        mwebView.loadUrl("file:///android_asset/mvvm.html");


     // mwebView.loadData(summary,"text/html",null);
    }
}
