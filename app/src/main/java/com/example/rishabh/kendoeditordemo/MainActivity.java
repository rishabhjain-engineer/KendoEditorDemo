package com.example.rishabh.kendoeditordemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    TextView textView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*textView = (TextView) findViewById(R.id.textView);*/
        webView = (WebView) findViewById(R.id.htmlView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setInitialScale(1);
        webView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
        webView.addJavascriptInterface(new MyJavaScriptInterface(this), "Interface");
        webView.loadUrl("file:///android_asset/test.html");
    }

    class MyJavaScriptInterface {

        Context mContext;
        String commentText;

        MyJavaScriptInterface(Context context) {
            mContext = context;
        }

        @JavascriptInterface
        public void showToast(String toast) {
            Log.d("RJ", "ShowToasttttttttttttttttttttttttttt");
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void showComment() {
            Log.e("RJ", "into method .... ");
            Log.e("RJ", "RIshabhhhhhhhhhhhh   : ");
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("$('#editor').data('kendoEditor').value();", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            Log.d("Rishbh :", "Value  : " + value);
                        }
                    });
                }
            });

        }
    }


}
