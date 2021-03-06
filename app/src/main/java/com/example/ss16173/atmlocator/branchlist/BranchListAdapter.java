package com.example.ss16173.atmlocator.branchlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.branchdetails.view.BranchDetailsActivity;
import com.example.ss16173.atmlocator.common.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susmita on 2/9/2018.
 */

public class BranchListAdapter extends RecyclerView.Adapter<BranchListAdapter.ViewHolder> {
    private List<Location> branchList;
    private Context context;
    private LayoutInflater layoutInflater;

    //constructor to initialize context and the pass data
    public BranchListAdapter(Context context, List<Location> branchList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.branchList = branchList;
    }

    //Inflate the layout when viewholder is created
    @Override
    public BranchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.branch_info, parent, false);
        return new ViewHolder(view, context, branchList);
    }

    @Override
    public void onBindViewHolder(BranchListAdapter.ViewHolder viewHolder, int position) {
        Location current = branchList.get(position);
        viewHolder.locationType.setText(current.getLocType());
        viewHolder.label.setText(current.getLabel());
        viewHolder.address.setText(current.getAddress());

        viewHolder.address2.setText(String.format(context.getResources().getString(R.string.address2text), current.getCity(), current.getState(), current.getZip()));
        viewHolder.distance.setText(String.format(context.getResources().getString(R.string.miles), String.valueOf(current.getDistance())));
    }

    @Override
    public int getItemCount() {
        return branchList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView locationType;
        TextView label;
        TextView address;
        TextView address2;
        TextView distance;
        View branchListLayout;
        List<Location> locationList = new ArrayList<>();
        Context context;


        private ViewHolder(View v, Context context, List<Location> locationList) {
            super(v);
            v.setOnClickListener(this);
            this.context = context;
            this.locationList = locationList;
            branchListLayout = v;
            locationType = v.findViewById(R.id.locType);
            label = v.findViewById(R.id.label);
            address = v.findViewById(R.id.address);
            address2 = v.findViewById(R.id.address2);
            distance = v.findViewById(R.id.distance);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Location location = locationList.get(position);
            Intent intent = new Intent(context, BranchDetailsActivity.class);
            intent.putExtra("location", location);
            this.context.startActivity(intent);
        }
    }


}
