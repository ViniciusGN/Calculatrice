package com.example.da_calculator.interfaces;

import io.reactivex.Observable;
import com.example.da_calculator.model.Rss;
import retrofit2.http.GET;

public interface IApiService {
    @GET("rss")
    Observable<Rss> getRSS();
}
