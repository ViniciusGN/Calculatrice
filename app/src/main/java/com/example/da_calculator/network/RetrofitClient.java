package com.example.da_calculator.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitClient {
    private static Retrofit instance = null;

    public static Retrofit getInstance(){
        if (instance == null) instance = new Retrofit.Builder().baseUrl("https://cointelegraph.com/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return instance;
    }
}
