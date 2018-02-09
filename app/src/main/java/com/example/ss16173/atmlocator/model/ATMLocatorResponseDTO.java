package com.example.ss16173.atmlocator.model;

import java.util.ArrayList;

/**
 * Created by ss16173 on 2/8/2018.
 */

public class ATMLocatorResponseDTO {
    private String errors;
    private ArrayList<Locations> locations;

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public ArrayList<Locations> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Locations> locations) {
        this.locations = locations;
    }
}
