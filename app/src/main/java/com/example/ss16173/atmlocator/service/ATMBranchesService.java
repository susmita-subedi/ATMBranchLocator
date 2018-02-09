package com.example.ss16173.atmlocator.service;

import android.content.res.Resources;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

/**
 * Created by ss16173 on 2/8/2018.
 */

public class ATMBranchesService {
    public void getATMBranches(String lat, String lang, LocationCallBack locationCallBack){
        String url = Resources.getSystem().getString(R.string.url_atm_branch);


        Retrofit retrofit = new Retrofit.Builder()
                .baseURL(url)
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<ATMLocatorResponseDTO> call = service.listRepos();
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                int statusCode = response.code();
//                User user = response.body();
        locationCallBack.onSuccess();
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                // Log error here since request failed
        locationCallBack.onError();
//            }
//        });




    }
    public interface LocationCallBack{
        void onSuccess();
        void onError();
    }
}
