package com.example.acronymapp.model.datasource.retrofit;

import com.example.acronymapp.model.datasource.acronym.Acronym;
import com.example.acronymapp.model.datasource.okhttp.OkHttpHelper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.acronymapp.model.Constants.ACTUAL_BASE_URL;
import static com.example.acronymapp.model.Constants.QUERY_RESULTS;

public class RetrofitHelper {

    public static Retrofit createRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ACTUAL_BASE_URL)
                .client(OkHttpHelper.getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<List<Acronym>> getAcronymOb(String aAcronym) {

        Retrofit retrofit = createRetrofit();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getAcronymObservable(aAcronym);

    }

    public interface RemoteService {

        @GET(QUERY_RESULTS)
        Observable<List<Acronym>> getAcronymObservable(@Query(QUERY_RESULTS) String acronym);

    }

}
