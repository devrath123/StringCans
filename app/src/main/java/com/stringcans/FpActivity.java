package com.stringcans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class FpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp);

        WebView tnc = findViewById(R.id.fp_wv);
        tnc.loadUrl("https://stringcans.com/resetmail");
    }
}