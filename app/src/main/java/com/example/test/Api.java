package com.example.test;

import com.example.test.Model.Detail;
import com.example.test.Model.ModelApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    //https://api.thecatapi.com/v1/images/search?limit=10&breed_ids=beng&api_key=REPLACE_ME
//    Api api = new Retrofit.Builder()
//            .baseUrl("https://api.thecatapi.com/v1/images/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(Api.class);

    @GET("search?limit=10&breed_ids=beng&api_key=REPLACE_ME")
    Call<ArrayList<ModelApi>> getListMeoCall();

    @GET("{position}")
    Call<Detail> getDetails(@Path(value = "position") String position );


}
