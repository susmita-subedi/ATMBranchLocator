package com.example.ss16173.atmlocator.findatm.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.branchlist.BranchListActivity;
import com.example.ss16173.atmlocator.findatm.FindATMContract;
import com.example.ss16173.atmlocator.findatm.presenter.ATMPresenterImpl;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

public class FindATMActivity extends AppCompatActivity implements FindATMContract.ATMView {

    private ProgressBar progressBar;

    private FindATMContract.ATMPresenter atmPresenter;
    //LocationUtil locationService = new LocationUtil(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atmPresenter = new ATMPresenterImpl();
        atmPresenter.setView(this);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
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

    @Override
    public void showATMList(ATMLocatorResponseDTO atmLocatorResponseDTO) {
        Intent intent = new Intent(this, BranchListActivity.class);
        intent.putExtra("atmLocatorResponse", atmLocatorResponseDTO);
        startActivity(intent);
    }

    public void onClickBtn(View view) {
        String lat = getLat();
        String lng = getLong();
        atmPresenter.loadATMBranchesList(lat, lng);
    }

    public String getLat() {
        // return String.valueOf(locationService.getLatitude());
        return "32.891677";
    }


    public String getLong() {
        return "-96.947753";
        //return String.valueOf(locationService.getLongitude());
    }
}