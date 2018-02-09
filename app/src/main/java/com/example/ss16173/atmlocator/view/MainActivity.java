package com.example.ss16173.atmlocator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ss16173.atmlocator.ATMContract;
import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.presenter.ATMPresenterImpl;

public class MainActivity extends AppCompatActivity implements ATMContract.ATMView {

    private ProgressBar progressBar;

    private ATMContract.ATMPresenter atmPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atmPresenter = new ATMPresenterImpl();
        atmPresenter.setView(this);
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
        atmPresenter.loadATMBranchesList(getLat(), getLong());
    }

    public String getLat(){
        String lat = "40.147864";
        return lat;
    }
    public String getLong(){
        String lng = "-82.990959";
        return lng;
    }
}