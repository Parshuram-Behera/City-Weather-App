package com.rrtech.webmobiassignment.API;

import com.rrtech.webmobiassignment.Models.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface APIInterface {

    @GET("v1/current.json")
    Call<WeatherData> getData(

            @Query("key") String APIkey ,
            @Query("q") String q,
            @Query("aqi") String airQ
    );

}
