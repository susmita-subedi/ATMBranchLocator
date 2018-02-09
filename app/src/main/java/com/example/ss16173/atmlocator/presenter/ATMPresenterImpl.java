package com.example.ss16173.atmlocator.presenter;

import com.example.ss16173.atmlocator.ATMContract;
import com.example.ss16173.atmlocator.service.ATMBranchesService;

/**
 * Created by ss16173 on 2/8/2018.
 */

public class ATMPresenterImpl implements ATMContract.ATMPresenter {

    ATMBranchesService atmBranchesService = new ATMBranchesService();
    ATMContract.ATMView atmView;

    @Override
    public void setView(ATMContract.ATMView view) {
        atmView = view;
    }

    @Override
    public void loadATMBranchesList(String lat, String lng) {

        //atmView.showLoader();
        atmBranchesService.getATMBranches(lat, lng, new ATMBranchesService.LocationCallBack() {
            @Override
            public void onSuccess() {
                atmView.hideLoader();
                atmView.showSuccess();
                System.out.println("success");
            }

            @Override
            public void onError() {
                atmView.hideLoader();
                atmView.showError();
            }
        });

    }

    @Override
    public void accessLocation() {

    }
}
