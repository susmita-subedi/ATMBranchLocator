package com.example.ss16173.atmlocator.network;

import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ss16173 on 2/8/2018.
 */

public interface RetrofitService {
    @GET("list.action")
    Call<ATMLocatorResponseDTO> callBranches(@Query("lat") String lat, @Query("lng") String lng);
}

