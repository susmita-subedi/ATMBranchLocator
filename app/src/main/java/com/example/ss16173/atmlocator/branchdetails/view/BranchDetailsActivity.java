package com.example.ss16173.atmlocator.branchdetails.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.Location;

/**
 * Created by susmita on 2/9/2018.
 */

public class BranchDetailsActivity extends AppCompatActivity {
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
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.first_layout, mapsFragment, mapsFragment.getTag())
                .commit();
        manager.beginTransaction()
                .replace(R.id.second_layout, branchDetailsFragment, branchDetailsFragment.getTag())
                .commit();

        Bundle sendBundle = new Bundle();
        sendBundle.putSerializable("location", location);
        mapsFragment.setArguments(bundle);
        branchDetailsFragment.setArguments(sendBundle);
    }


   /* @Override
    public void showMarker(String lat, String lng) {
        mapsFragment = (MapsFragment) getSupportFragmentManager().findFragmentById(R.id.second_layout);
        mapsFragment.showMarker(lat, lng);
    }*/
}
