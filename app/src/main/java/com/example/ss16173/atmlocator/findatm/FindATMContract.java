package com.example.ss16173.atmlocator.findatm;

/**
 * Created by ss16173 on 2/8/2018.
 */

public interface FindATMContract {

    interface ATMView {

        void showSuccess();

        void showError();

        void showLoader();

        void hideLoader();

       // void showATMList();
    }

    interface ATMPresenter {
        void loadATMBranchesList(String lat, String lng);

        void setView(ATMView view);
    }

}
