package com.example.ss16173.atmlocator.branchdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ss16173.atmlocator.R;

/**
 * Created by susmita on 2/10/2018.
 */

public class BranchInfoFragment extends Fragment {

    private static TextView distance;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.branch_info, container, false);

        distance = (TextView) view.findViewById(R.id.distance);
        distance.setText("15 miles");
        return view;
    }
}
