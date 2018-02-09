package com.example.ss16173.atmlocator.network;

import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

/**
 * Created by ss16173 on 2/8/2018.
 */

public interface RetrofitService {
        @GET("lat/{lat}/lng/{long}")
        Call<ATMLocatorResponseDTO> listRepos(@Path("lat") String lat, @Path("long") String lng);
    }

