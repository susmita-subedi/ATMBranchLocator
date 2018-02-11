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
    ATMLocatorResponseDTO atmLocatorResponseDTO = new ATMLocatorResponseDTO();
    static final String BASE_URL = Resources.getSystem().getString(R.string.url_atm_branch);
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
