package com.example.da_calculator.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.da_calculator.model.Rss;
import com.example.da_calculator.repository.MainRepository;

public class MainViewModel extends ViewModel {
    private MainRepository mainRepository;

    public MainViewModel(){
        mainRepository = new MainRepository();
    }

    public LiveData<Rss> getRss(){
        return mainRepository.getRssMutableLiveData();
    }

    public  LiveData<String> getError(){
        return mainRepository.getError();
    }

    public void clear(){
        mainRepository.clear();
    }
}
