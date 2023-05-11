package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class a4 extends AppCompatActivity {
    private WebView git_hub = null;
    private ImageView back_btn;
    private String url = "https://github.com/gyur2";

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && git_hub.canGoBack()) {
            git_hub.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4);
        back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a4.this, a3.class);
                startActivity(intent);
            }
        });
        git_hub = (WebView) findViewById(R.id.git_hub);
        git_hub.getSettings().setJavaScriptEnabled(true);
        git_hub.loadUrl(url);
        git_hub.setWebChromeClient(new WebChromeClient());
        git_hub.setWebViewClient(new WebViewClientClass());


    }

    private class WebViewClientClass extends WebViewClient {
        @Override //chrome 말고도 사용가능하도록 함수를 열어줍니다.
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}