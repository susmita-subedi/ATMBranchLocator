package com.example.ss16173.atmlocator.findatm.presenter;

import com.example.ss16173.atmlocator.findatm.FindATMContract;
import com.example.ss16173.atmlocator.findatm.service.FindATMBranchesService;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

/**
 * Created by ss16173 on 2/8/2018.
 */

public class ATMPresenterImpl implements FindATMContract.ATMPresenter {

    FindATMBranchesService atmBranchesService = new FindATMBranchesService();
    FindATMContract.ATMView atmView;

    @Override
    public void setView(FindATMContract.ATMView view) {
        atmView = view;
    }

    @Override
    public void loadATMBranchesList(String lat, String lng) {

        atmView.showLoader();
        atmBranchesService.getATMBranches(lat, lng, new FindATMBranchesService.LocationCallBack() {
            @Override
            public void onError() {
                atmView.showError();
                atmView.hideLoader();
            }

            @Override
            public void onSuccess(ATMLocatorResponseDTO successResponse) {
                atmView.showSuccess();
                atmView.showATMList(successResponse);
                atmView.hideLoader();
            }
        });


    }


}
