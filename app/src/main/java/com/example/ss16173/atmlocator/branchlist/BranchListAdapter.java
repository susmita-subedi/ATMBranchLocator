package com.example.ss16173.atmlocator.branchlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.model.Location;

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
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BranchListAdapter.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Location current = branchList.get(position);
        viewHolder.locationType.setText(current.getLocType());
        viewHolder.label.setText(current.getLabel());
        viewHolder.address.setText(current.getAddress());
        viewHolder.address2.setText(current.getCity() + ", " + current.getState() + " " + current.getZip());
        viewHolder.distance.setText(String.valueOf(current.getDistance()));

    }

    @Override
    public int getItemCount() {
        return branchList.size();
    }

    public void add(int position, Location location) {
        branchList.add(position, location);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView locationType;
        public TextView label;
        public TextView address;
        public TextView address2;
        public TextView distance;
        public View branchListLayout;

        public ViewHolder(View v) {
            super(v);
            branchListLayout = v;
            locationType = (TextView) v.findViewById(R.id.locType);
            label = (TextView) v.findViewById(R.id.label);
            address = (TextView) v.findViewById(R.id.address);
            address2 = (TextView) v.findViewById(R.id.address2);
            distance = (TextView) v.findViewById(R.id.distance);

        }

    }


}
