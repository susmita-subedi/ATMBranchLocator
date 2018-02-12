package com.example.ss16173.atmlocator.branchdetails.view;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.common.model.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Location location;
    private View mView;
    private String lat, lng;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null && (bundle.getSerializable("location") != null)) {
            location = (Location) bundle.getSerializable("location");
        }
        mView = inflater.inflate(R.layout.maps_fragment, container, false);
        SupportMapFragment mapFragment=(SupportMapFragment)this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return mView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Double lt = Double.valueOf(location.getLat());
        Double lang = Double.valueOf(location.getLng());
        LatLng branch = new LatLng(lt, lang);
        mMap.addMarker(new MarkerOptions().position(branch));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(branch));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 20, null);

    }

}
