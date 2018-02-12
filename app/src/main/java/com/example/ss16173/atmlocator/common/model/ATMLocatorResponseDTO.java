package com.example.ss16173.atmlocator.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by susmita on 2/8/2018.
 */

public class ATMLocatorResponseDTO implements Serializable {

    private List<Object> errors = null;

    private List<Location> locations = null;

    public ATMLocatorResponseDTO(List<Object> errors, List<Location> locations) {
        this.errors = errors;
        this.locations = locations;
    }

    public ATMLocatorResponseDTO() {
    }

    public List<Object> getErrors() {
        return errors;
    }

    public List<Location> getLocations() {
        return locations;
    }

}