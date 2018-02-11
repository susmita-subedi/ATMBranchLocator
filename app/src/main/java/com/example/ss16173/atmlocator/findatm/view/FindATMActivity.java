package com.example.ss16173.atmlocator.findatm.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.example.ss16173.atmlocator.util.PermissionUtil;

public class FindATMActivity extends AppCompatActivity implements FindATMContract.ATMView {

    private ProgressBar progressBar;
    SearchFragment searchFragment;
    Context context;
    private FindATMContract.ATMPresenter atmPresenter;
    LocationUtil locationService = new LocationUtil(this);

    private static final int REQUEST_LOCATION = 100;
    private static final int TXT_LOCATION = 1;

    private PermissionUtil permissionUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atmPresenter = new ATMPresenterImpl();
        atmPresenter.setView(this);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        searchFragment = new SearchFragment();

        permissionUtil = new PermissionUtil(this);

    }

    //check whether the method is already granted or not. If it is granted already, don't prompt the user requesting for the same permission
    private int checkPermission(int permission) {
        int status = PackageManager.PERMISSION_DENIED;
        // int status2 = PackageManager.PERMISSION_DENIED;

        switch (permission) {
            case TXT_LOCATION:
                status = ContextCompat.checkSelfPermission(this, Manifest.permission_group.LOCATION);
                //status2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
                break;
        }

        //to check if one  permission is granted but the other is not granted, deny the location permission
       /* if(status > status2){
            status = status2;
        }*/
        return status;
    }

    //method to request new permission
    private void requestPermission(int permission) {
        switch (permission) {
            case TXT_LOCATION:
                ActivityCompat.requestPermissions(FindATMActivity.this,
                        new String[]{Manifest.permission_group.LOCATION}, REQUEST_LOCATION);
                break;
        }
    }

    //if the user denied permission for the first time, show this dialogue box requesting for permission




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