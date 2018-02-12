package com.example.ss16173.atmlocator.findatm.service;

import android.content.res.Resources;
import android.util.Log;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;
import com.example.ss16173.atmlocator.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by susmita on 2/8/2018.
 */

public class FindATMBranchesService {
    private ATMLocatorResponseDTO atmLocatorResponseDTO = new ATMLocatorResponseDTO();
    private static final String BASE_URL = "https://m.chase.com/PSRWeb/location/";
    public void getATMBranches(String lat, String lang, final LocationCallBack callback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<ATMLocatorResponseDTO> call = service.callBranches(lat, lang);
        call.enqueue(new Callback<ATMLocatorResponseDTO>() {
            @Override
            public void onResponse(Call<ATMLocatorResponseDTO> call, Response<ATMLocatorResponseDTO> response) {
                //if (response != null && response.body() != null && !(response.body().getLocations().isEmpty())) {
                if ((response.isSuccessful()) && (response.body() != null) && (response.body().getLocations() != null) && !(response.body().getLocations().isEmpty())) {
                    atmLocatorResponseDTO = response.body();
                    callback.onSuccess(atmLocatorResponseDTO);
                } else {
                    Log.e("Service call failure", response.message());
                    callback.onError("Unable to find ATMs/Branch near you. Please try again later.");
                }
            }

            @Override
            public void onFailure(Call<ATMLocatorResponseDTO> call, Throwable t) {
                Log.e("service call", "failure");
                callback.onError(Resources.getSystem().getString(R.string.service_error));
                //todo alert box
            }
        });


    }

    public interface LocationCallBack {
        void onError(String error);

        void onSuccess(ATMLocatorResponseDTO successResponse);
    }
}
