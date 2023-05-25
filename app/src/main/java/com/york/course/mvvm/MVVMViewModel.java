package com.york.course.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MVVMViewModel extends ViewModel {

    private MutableLiveData<Integer> _counterLive = new MutableLiveData<Integer>(0);
    public LiveData<Integer> counterLive = _counterLive;

    public void buttonClicked() {
        int counter = _counterLive.getValue();
       _counterLive.postValue(++counter);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
