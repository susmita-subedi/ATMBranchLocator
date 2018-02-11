package com.example.ss16173.atmlocator.branchdetails.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susmita on 2/10/2018.
 */

public class BranchDetailsFragment extends Fragment {

    private TextView distance;
    private Location location;
    private TextView locationType;
    private TextView label;
    private TextView address;
    private TextView address2;
    private TextView atms;
    private TextView lobby;
    private TextView driveUp;
    private TextView type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null && (bundle.getSerializable("location") != null)) {
            location = (Location) bundle.getSerializable("location");
        }
        View view = inflater.inflate(R.layout.branch_details_fragment, container, false);
        initializeViews(view);
        populateBranchDetailsView();
        return view;
    }

    public void initializeViews(View view) {
        locationType = (TextView) view.findViewById(R.id.locType);
        label = (TextView) view.findViewById(R.id.label);
        address = (TextView) view.findViewById(R.id.address);
        address2 = (TextView) view.findViewById(R.id.address2);
        atms = (TextView) view.findViewById(R.id.atm_count);
        lobby = (TextView) view.findViewById(R.id.lobby_hours);
        driveUp = (TextView) view.findViewById(R.id.drive_up_hours);
        type = (TextView) view.findViewById(R.id.type);
    }

    public void populateBranchDetailsView() {
        locationType.setText(location.getLocType());
        label.setText(location.getLocType());
        address.setText(location.getAddress());
        address2.setText(location.getCity() + ", " + location.getState() + " " + location.getZip());
        distance.setText(String.valueOf(location.getDistance())+" miles");
        atms.setText(String.valueOf(location.getAtms()));

        List<String> weekList = new ArrayList<String>();

        List<String> lobbyHrList ;
        lobbyHrList = location.getLobbyHrs();
        for(int i = 0; i<lobbyHrList.size(); i++){
            if (!lobbyHrList.get(i).isEmpty()){
                lobby.append(lobbyHrList.get(i));
            }
            else{
                lobby.append(getResources().getString(R.string.));
            }
        }
        label.setText(location.getLocType());
    }

}
