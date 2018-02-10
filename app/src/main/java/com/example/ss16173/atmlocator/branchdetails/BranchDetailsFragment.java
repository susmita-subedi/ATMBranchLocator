package com.example.ss16173.atmlocator.branchdetails;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.Location;

/**
 * Created by susmita on 2/10/2018.
 */

public class BranchDetailsFragment extends Fragment {

    private static TextView distance;
    private Location location;
    private String dist;

    BranchDetailsFragmentListener branchDetailsFragmentListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null && (bundle.getString("location") != null)) {
            dist = bundle.getString("location");
        }
        View view = inflater.inflate(R.layout.branch_details_fragment, container, false);
        distance = (TextView) view.findViewById(R.id.distance);
        distance.setText((String.valueOf(dist)) + "miles");
        branchDetailsFragmentListener.showMarker("10", "20");

        return view;
    }

    public interface BranchDetailsFragmentListener {

        public void showMarker(String lat, String lng);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            branchDetailsFragmentListener = (BranchDetailsFragmentListener) context;
        } catch (Exception e) {
            Log.e("fragment listener", e.getMessage());
        }
    }


}
