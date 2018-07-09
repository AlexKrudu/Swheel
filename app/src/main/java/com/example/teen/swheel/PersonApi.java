package com.example.teen.swheel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PersonApi {
    @POST("/api/get")
    Call<List<RegistrationResp>> getData(@Query("name") String resourceName, @Query("num") int count);
    @GET("/api/get")
    Call<List<RegistrationSend>> getData1(@Query("name") String resourceName, @Query("num") int count);
    @GET("/api/get")
    Call<List<SigningResp>> getData2(@Query("name") String resourceName, @Query("num") int count);
    @GET("/api/get")
    Call<List<SigningSend>> getData3(@Query("name") String resourceName, @Query("num") int count);
    @GET("/api/get")
    Call<List<GetCoords>> getData4(@Query("name") String resourceName, @Query("num") int count);
    @GET("/api/get")
    Call<List<PutCoords>> getData5(@Query("name") String resourceName, @Query("num") int count);

}
