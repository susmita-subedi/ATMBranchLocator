package com.example.ss16173.atmlocator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ss16173.atmlocator.ATMContract;
import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.presenter.ATMPresenterImpl;
import com.example.ss16173.atmlocator.service.FindLocationService;

public class MainActivity extends AppCompatActivity implements ATMContract.ATMView {

    private ProgressBar progressBar;

    private ATMContract.ATMPresenter atmPresenter;
    //FindLocationService locationService = new FindLocationService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atmPresenter = new ATMPresenterImpl();
        atmPresenter.setView(this);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    public void onClickBtn(View view) {
        String lat = getLat();
        String lng = getLong();
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
        atmPresenter.loadATMBranchesList(lat, lng);
    }

    public String getLat() {
       // return String.valueOf(locationService.getLatitude());
        return "40.147864";
    }


    public String getLong() {
        return "-82.990959";
        //return String.valueOf(locationService.getLongitude());
    }
}