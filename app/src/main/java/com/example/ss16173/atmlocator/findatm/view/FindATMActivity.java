package com.example.ss16173.atmlocator.findatm.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.branchlist.BranchListActivity;
import com.example.ss16173.atmlocator.common.SearchFragment;
import com.example.ss16173.atmlocator.findatm.FindATMContract;
import com.example.ss16173.atmlocator.findatm.presenter.ATMPresenterImpl;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;
import com.example.ss16173.atmlocator.util.LocationUtil;

public class FindATMActivity extends AppCompatActivity implements FindATMContract.ATMView {

    private ProgressBar progressBar;
    SearchFragment searchFragment;
    Context context;
    private FindATMContract.ATMPresenter atmPresenter;
    LocationUtil locationService = new LocationUtil(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atmPresenter = new ATMPresenterImpl();
        atmPresenter.setView(this);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        searchFragment = new SearchFragment();

    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showError() {

        /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle("Error");

        // set dialog message
        alertDialogBuilder
                .setMessage("Your request could not be processed at the moment. Please try again later.")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        FindATMActivity.this.finish();
                    }
                });


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();*/
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
        Location location = locationService.getLoc();
        String lat = String.valueOf(location.getLatitude());
        String lng = String.valueOf(location.getLongitude());
        atmPresenter.loadATMBranchesList(lat, lng);
    }

}