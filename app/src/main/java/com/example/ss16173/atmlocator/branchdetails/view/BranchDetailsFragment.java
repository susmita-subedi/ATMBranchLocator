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
        locationType = view.findViewById(R.id.locType);
        label = view.findViewById(R.id.label);
        address = view.findViewById(R.id.address);
        address2 = view.findViewById(R.id.address2);
        distance = view.findViewById(R.id.distance);
        atms = view.findViewById(R.id.atm_count);
        lobby = view.findViewById(R.id.lobby_hours);
        driveUp = view.findViewById(R.id.drive_up_hours);
        type = view.findViewById(R.id.type);
    }

    public void populateBranchDetailsView() {
        locationType.setText(location.getLocType());
        label.setText(location.getLabel());
        address.setText(location.getAddress());
        address2.setText(location.getCity() + ", " + location.getState() + " " + location.getZip());
        distance.setText(String.valueOf(location.getDistance()) + " miles");
        String atmCnt = location.getAtms().toString();
        atms.setText(atmCnt);

        List<String> weekList = new ArrayList<>();
        weekList.add(getResources().getString(R.string.sun));
        weekList.add(getResources().getString(R.string.mon));
        weekList.add(getResources().getString(R.string.tue));
        weekList.add(getResources().getString(R.string.wed));
        weekList.add(getResources().getString(R.string.thurs));
        weekList.add(getResources().getString(R.string.fri));
        weekList.add(getResources().getString(R.string.sat));

        List<String> lobbyHrList;
        lobbyHrList = location.getLobbyHrs();
        for (int i = 0; i < weekList.size(); i++) {
            if (!lobbyHrList.get(i).isEmpty()) {
                lobby.append(weekList.get(i) + " " + lobbyHrList.get(i) + "\n");
            } else {
                lobby.append(weekList.get(i) + " " + getResources().getString(R.string.closed_status) + "\n");
            }
        }

        List<String> driveUpHours;
        driveUpHours = location.getDriveUpHrs();
        for (int i = 0; i < weekList.size(); i++) {
            if (!driveUpHours.get(i).isEmpty()) {
                driveUp.append(weekList.get(i) + " " + driveUpHours.get(i) + "\n");
            } else {
                driveUp.append(weekList.get(i) + " " + getResources().getString(R.string.closed_status) + "\n");
            }
        }
        type.setText(location.getType());
    }

}
