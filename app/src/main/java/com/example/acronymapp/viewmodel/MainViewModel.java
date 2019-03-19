package com.example.acronymapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.acronymapp.model.datasource.acronym.Acronym;
import com.example.acronymapp.model.datasource.retrofit.RetrofitHelper;
import com.example.acronymapp.model.datasource.rxjava.DataSourceRepo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    MutableLiveData<List<Acronym>> acronymLiveData;
    String givenText;

    public MainViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    public void init() {
        acronymLiveData = new MutableLiveData<>();
    }

    public void onTextChanged(CharSequence s) {
        Log.d("TAG", "onTextChanged: " + s);
        givenText = s.toString();
    }

    public void searchButtonClick(){
        Log.d("TAG", "searchButtonClick: " + givenText);
        getResultForAPICall();
    }

    public void getResultForAPICall() {

        RetrofitHelper retrofitHelper = new RetrofitHelper();

        retrofitHelper.getAcronymOb(givenText)
                .subscribeOn(Schedulers.io())
                .retryWhen(o ->
                        o.take(5).delay(2, TimeUnit.SECONDS))
                .doOnError(throwable -> {
                    throw new RuntimeException("Data Corrupted");
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Acronym>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.d("TAG", "onSubscribe: ");

                    }

                    @Override
                    public void onNext(List<Acronym> acronyms) {

                        if(acronyms != null) {

                            acronymLiveData.setValue(acronyms);

                        }
                        else {

                            Log.d("TAG", "NULL!!!");

                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("TAG", "onError: " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public LiveData<List<Acronym>> getAcronymLiveData() {

        return acronymLiveData;

    }
}
