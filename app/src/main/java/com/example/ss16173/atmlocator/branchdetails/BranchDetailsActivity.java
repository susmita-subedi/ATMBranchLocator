package com.example.ss16173.atmlocator.branchdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.Location;

/**
 * Created by susmita on 2/9/2018.
 */

public class BranchDetailsActivity extends AppCompatActivity implements BranchDetailsFragment.BranchDetailsFragmentListener {
    private Location location;
    private TextView distance;
    MapsFragment mapsFragment;
    BranchDetailsFragment branchDetailsFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branch_details);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getSerializable("location") != null) {
            location = (Location) bundle.getSerializable("location");
        } else {
            Log.e("Error in intent", "Could not find ATMLocatorResponse in Intent");
        }
        branchDetailsFragment = new BranchDetailsFragment();
        mapsFragment = new MapsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.branchDetailsFragment, branchDetailsFragment);
        transaction.commit();
        /*FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.mapFragment, mapsFragment);
        transaction2.commit();*/

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.first_layout, branchDetailsFragment);
        Bundle sendBundle = new Bundle();
        sendBundle.putString("location", "10");
       // mapsFragment.setArguments(bundle);
        branchDetailsFragment.setArguments(sendBundle);
    }


    @Override
    public void showMarker(String lat, String lng) {
            mapsFragment = (MapsFragment)getSupportFragmentManager().findFragmentById(R.id.mapFragment);
            mapsFragment.showMarker(lat, lng);
    }
}
