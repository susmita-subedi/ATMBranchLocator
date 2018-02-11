package com.example.ss16173.atmlocator.findatm;

import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

/**
 * Created by susmita on 2/8/2018.
 */

public interface FindATMContract {

    interface ATMView {

        void showSuccess();

        void showError(String title);

        void showLoader();

        void hideLoader();

        void showATMList(ATMLocatorResponseDTO dto);
    }

    interface ATMPresenter {
        void loadATMBranchesList(String lat, String lng);
        void setView(ATMView view);
    }

}
