package com.example.da_calculator.repository;

import android.util.AndroidException;

import androidx.lifecycle.MutableLiveData;

import com.example.da_calculator.interfaces.IApiService;
import com.example.da_calculator.model.Rss;
import com.example.da_calculator.network.RetrofitClient;

import java.lang.invoke.MutableCallSite;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class MainRepository {
    private MutableLiveData<Rss> rssMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private IApiService apiService;

    public MainRepository(){
        apiService = RetrofitClient.getInstance().create(IApiService.class);
    }

    public MutableLiveData<Rss> getRssMutableLiveData(){
        compositeDisposable.add(
                apiService.getRSS()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(rss -> {
                            rssMutableLiveData.setValue(rss);

                        }, throwable -> {
                            error.setValue(throwable.getMessage());
                        })
        );

        return  rssMutableLiveData;
    }

    public MutableLiveData<String> getError(){
        return error;
    }

    public void clear(){
        compositeDisposable.clear();
    }

}
