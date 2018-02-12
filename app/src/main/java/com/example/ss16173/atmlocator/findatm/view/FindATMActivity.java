package com.example.ss16173.atmlocator.findatm.view;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.branchlist.BranchListActivity;
import com.example.ss16173.atmlocator.common.SearchFragment;
import com.example.ss16173.atmlocator.findatm.FindATMContract;
import com.example.ss16173.atmlocator.findatm.presenter.ATMPresenterImpl;
import com.example.ss16173.atmlocator.common.model.ATMLocatorResponseDTO;
import com.example.ss16173.atmlocator.common.util.LocationUtil;
import com.example.ss16173.atmlocator.common.util.PermissionUtil;

import java.io.IOException;

public class FindATMActivity extends AppCompatActivity implements FindATMContract.ATMView {

    private ProgressBar progressBar;
    SearchFragment searchFragment;
    private FindATMContract.ATMPresenter atmPresenter;
    LocationUtil locationService = new LocationUtil(this);
    Context context;
    PermissionUtil permissionUtil;
    private static final int REQUEST_LOCATION = 100;
    private static final int TXT_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atmPresenter = new ATMPresenterImpl();
        atmPresenter.setView(this);
        progressBar = findViewById(R.id.progress_bar);

        searchFragment = new SearchFragment();

        permissionUtil = new PermissionUtil(this);

    }

    //check whether the permission is already granted or not. If it is granted already, don't prompt the user requesting for the same permission
    private int checkPermission(int permission) {
        int status = PackageManager.PERMISSION_DENIED;
        // int status2 = PackageManager.PERMISSION_DENIED;

        switch (permission) {
            case TXT_LOCATION:
                status = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
                break;
        }

        return status;
    }

    //method to request new permission
    private void requestPermission(int permission) {
        switch (permission) {
            case TXT_LOCATION:
                ActivityCompat.requestPermissions(FindATMActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
                break;
        }
    }


    @Override
    public void showSuccess() {

    }

    @Override
    public void showError(final String title) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle(getResources().getString(R.string.attention));

        // set dialog message
        alertDialogBuilder
                .setMessage(title)
                .setCancelable(true)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        if (title.equalsIgnoreCase(getString(R.string.service_error))) {
                            dialog.dismiss();
                        } else if (title.equalsIgnoreCase(getString(R.string.request_permission))) {
                            requestPermission(TXT_LOCATION);
                        }
                    }
                });
        if (title.equalsIgnoreCase(getString(R.string.request_permission))) {
            alertDialogBuilder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
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

    public void onClickBtn(View view) throws IOException, InterruptedException {
        if (isConnectedToInternet()) {
            if ((Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1)) {
                if (checkPermission(TXT_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(FindATMActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        showError(getString(R.string.request_permission));
                    } else if (!permissionUtil.checkPermissionPreference("location")) {
                        requestPermission(TXT_LOCATION);
                        permissionUtil.updatePermissionPreference("location");
                    } else {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
                        intent.setData(uri);
                        this.startActivity(intent);
                    }

                } else {
                    getBranchList();
                }
            } else {
                getBranchList();
            }
        } else {
            showError("No internet");
        }
    }


    public void getBranchList() {
        Location location = locationService.getLoc();
        String lat = String.valueOf(location.getLatitude());
        String lng = String.valueOf(location.getLongitude());
        atmPresenter.loadATMBranchesList(lat, lng);
    }

    public boolean isConnectedToInternet() throws InterruptedException, IOException {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
