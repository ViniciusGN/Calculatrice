package com.example.da_calculator;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.da_calculator.databinding.ActivityWebViewBinding;

public class WebViewActivity extends AppCompatActivity {
    ActivityWebViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initBinding();
        navigateUrl();
    }

    private void navigateUrl() {
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String url = extras.getString("url");
            if (!TextUtils.isEmpty(url)) {
                binding.webView.getSettings().setJavaScriptEnabled(true);
                binding.webView.getSettings().setDomStorageEnabled(true);
                binding.webView.loadUrl(url);
            }
        }
    }

    private void initBinding(){
        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
