package com.example.ss16173.atmlocator.presenter;

import com.example.ss16173.atmlocator.ATMContract;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;
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

        atmView.showLoader();
        atmBranchesService.getATMBranches(lat, lng, new ATMBranchesService.LocationCallBack() {
            @Override
            public void onError() {
                atmView.showError();

                atmView.hideLoader();
            }

            @Override
            public void onSuccess(ATMLocatorResponseDTO successResponse) {
                atmView.showSuccess();

                atmView.hideLoader();
            }
        });


    }


}
