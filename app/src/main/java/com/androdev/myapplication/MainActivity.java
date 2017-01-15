package com.androdev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);


        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/pdfviewer/index.html");

    }

    //	reload on resume
    @Override
    protected void onResume() {
        super.onResume();
        webView.loadUrl( "javascript:window.location.reload( true )" );

    }

    //	clear cache to ensure we have good reload
    @Override
    protected void onPause() {
        super.onPause();
        webView.clearCache(true);

    }

}
