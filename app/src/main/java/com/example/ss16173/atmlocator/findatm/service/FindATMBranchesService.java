package com.example.ss16173.atmlocator.findatm.service;

import android.app.LauncherActivity;
import android.util.Log;

import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;
import com.example.ss16173.atmlocator.model.Location;
import com.example.ss16173.atmlocator.network.RetrofitService;
import com.example.ss16173.atmlocator.util.ATMLocatorResponseParser;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ss16173 on 2/8/2018.
 */

public class FindATMBranchesService {
    ATMLocatorResponseParser atmLocatorResponseParser = new ATMLocatorResponseParser();
    ATMLocatorResponseDTO atmLocatorResponseDTO = new ATMLocatorResponseDTO();

    public void getATMBranches(String lat, String lang, final LocationCallBack callback) {
        String url = "https://m.chase.com/PSRWeb/location/";

        ATMLocatorResponseParser parser = new ATMLocatorResponseParser();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<ATMLocatorResponseDTO> call = service.callBranches(lat, lang);
        call.enqueue(new Callback<ATMLocatorResponseDTO>() {
            @Override
            public void onResponse(Call<ATMLocatorResponseDTO> call, Response<ATMLocatorResponseDTO> response) {
                atmLocatorResponseDTO = response.body();
                callback.onSuccess(atmLocatorResponseDTO);
            }

            @Override
            public void onFailure(Call<ATMLocatorResponseDTO> call, Throwable t) {
                Log.d("service call", "failure");
                callback.onError();
                //todo alert box
            }
        });


    }

    public interface LocationCallBack {
        void onError();

        void onSuccess(ATMLocatorResponseDTO successResponse);
    }
}
