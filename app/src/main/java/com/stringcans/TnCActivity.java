package com.stringcans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class TnCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn_c);

        WebView tnc = findViewById(R.id.tnc_wv);
        tnc.loadUrl("https://stringcans.com/terms-and-conditions");
    }
}