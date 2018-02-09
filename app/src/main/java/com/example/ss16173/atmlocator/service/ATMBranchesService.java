package com.example.ss16173.atmlocator.service;

import android.content.res.Resources;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;
import com.example.ss16173.atmlocator.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ss16173 on 2/8/2018.
 */

public class ATMBranchesService {
    public void getATMBranches(String lat, String lang, final LocationCallBack locationCallBack) {
        String url = Resources.getSystem().getString(R.string.url_atm_branch);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<ATMLocatorResponseDTO> call = service.listRepos(lat, lang);
        call.enqueue(new Callback<ATMLocatorResponseDTO>() {
            @Override
            public void onResponse(Call<ATMLocatorResponseDTO> call, Response<ATMLocatorResponseDTO> response) {
                int statusCode = response.code();
                locationCallBack.onSuccess();
            }

            @Override
            public void onFailure(Call<ATMLocatorResponseDTO> call, Throwable t) {
                locationCallBack.onError();
            }

        });


    }

    public interface LocationCallBack {
        void onSuccess();

        void onError();
    }
}
