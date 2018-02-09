package com.example.ss16173.atmlocator.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by susmita on 2/9/2018.
 */

public class Location implements Serializable {

    private String state;
    private String locType;
    private String label;
    private String address;
    private String city;
    private String zip;
    private String name;
    private String lat;
    private String lng;
    private String bank;
    private String type;
    private List<String> lobbyHrs = null;
    private List<String> driveUpHrs = null;
    private Integer atms;
    private List<String> services = null;
    private String phone;
    private double distance;
    private String access;

    public Location(String state, String locType, String label, String address, String city, String zip, String name, String lat, String lng, String bank, String type, List<String> lobbyHrs, List<String> driveUpHrs, Integer atms, List<String> services, String phone, double distance, String access) {
        this.state = state;
        this.locType = locType;
        this.label = label;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.bank = bank;
        this.type = type;
        this.lobbyHrs = lobbyHrs;
        this.driveUpHrs = driveUpHrs;
        this.atms = atms;
        this.services = services;
        this.phone = phone;
        this.distance = distance;
        this.access = access;
    }

    public Location() {
    }

    public String getState() {
        return state;
    }

    public String getLocType() {
        return locType;
    }

    public String getLabel() {
        return label;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getName() {
        return name;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getBank() {
        return bank;
    }

    public String getType() {
        return type;
    }

    public List<String> getLobbyHrs() {
        return lobbyHrs;
    }

    public List<String> getDriveUpHrs() {
        return driveUpHrs;
    }

    public Integer getAtms() {
        return atms;
    }

    public List<String> getServices() {
        return services;
    }

    public String getPhone() {
        return phone;
    }

    public double getDistance() {
        return distance;
    }

    public String getAccess() {
        return access;
    }
}
