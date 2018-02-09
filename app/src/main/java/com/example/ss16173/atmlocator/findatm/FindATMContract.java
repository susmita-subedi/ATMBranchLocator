package com.example.ss16173.atmlocator;

/**
 * Created by ss16173 on 2/8/2018.
 */

public interface ATMContract {

    interface ATMView {

        void showSuccess();

        void showError();

        void showLoader();

        void hideLoader();
    }

    interface ATMPresenter {
        void loadATMBranchesList(String lat, String lng);

        void setView(ATMView view);
    }

}
