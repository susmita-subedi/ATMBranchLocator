package com.example.ss16173.atmlocator.branchlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;
import com.example.ss16173.atmlocator.model.Location;

import java.util.List;

/**
 * Created by susmita on 2/8/2018.
 */

public class BranchListActivity extends AppCompatActivity {

    RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
    ATMLocatorResponseDTO atmLocatorResponseDTO;
    private RecyclerView branchListView;
    private BranchListAdapter branchListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branch_list);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getSerializable("atmLocatorResponse") != null) {
            atmLocatorResponseDTO = (ATMLocatorResponseDTO) bundle.getSerializable("atmLocatorResponse");
        } else {
            Log.e("Error in intent", "Could not find ATMLocatorResponse in Intent");
        }

        List<Location> locationList = atmLocatorResponseDTO.getLocations();
        branchListView = (RecyclerView) findViewById(R.id.branch_recycler_view);
        branchListAdapter = new BranchListAdapter(this, locationList);
        branchListView.setLayoutManager(recyclerViewLayoutManager);
        branchListView.setAdapter(branchListAdapter);
    }
}
