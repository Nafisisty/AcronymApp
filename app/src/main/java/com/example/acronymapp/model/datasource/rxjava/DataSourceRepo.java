package com.example.acronymapp.model.datasource.rxjava;

import android.util.Log;

import com.example.acronymapp.model.datasource.acronym.Acronym;
import com.example.acronymapp.model.datasource.retrofit.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataSourceRepo {

    RetrofitHelper retrofitHelper = new RetrofitHelper();

    List<Acronym> acronymList;

//    public List<Acronym> getAcronymResponse(String inputString) {
//
//        retrofitHelper.getAcronymOb(inputString)
//                .subscribeOn(Schedulers.io())
//                .retryWhen(o ->
//                    o.take(5).delay(2, TimeUnit.SECONDS))
//                .doOnError(throwable -> {
//                    throw new RuntimeException("Data Corrupted");
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Acronym>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                        Log.d("TAG", "onSubscribe: ");
//
//                    }
//
//                    @Override
//                    public void onNext(List<Acronym> acronyms) {
//
//                        if(acronyms != null) {
//
//                            acronymList = acronyms;
//                            Log.d("TAG", "GOT DATA!!!" + acronymList.get(0).getSf() );
//
//                        }
//                        else {
//
//                            Log.d("TAG", "NULL!!!");
//
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                        Log.d("TAG", "onError: " + e.getMessage());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//        return acronymList;
//    }
}
