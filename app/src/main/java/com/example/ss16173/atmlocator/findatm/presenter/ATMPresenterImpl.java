package com.example.ss16173.atmlocator.findatm.presenter;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.findatm.FindATMContract;
import com.example.ss16173.atmlocator.findatm.service.FindATMBranchesService;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

/**
 * Created by susmita on 2/8/2018.
 */

public class ATMPresenterImpl implements FindATMContract.ATMPresenter {

    private FindATMBranchesService atmBranchesService = new FindATMBranchesService();
    private FindATMContract.ATMView atmView;

    @Override
    public void setView(FindATMContract.ATMView view) {
        atmView = view;
    }

    @Override
    public void loadATMBranchesList(String lat, String lng) {

        atmView.showLoader();
        atmBranchesService.getATMBranches(lat, lng, new FindATMBranchesService.LocationCallBack() {
            @Override
            public void onError(String error) {
                atmView.showError(error);
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
