/*
package com.example.ss16173.atmlocator.util;

import android.util.Log;

import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;
import com.example.ss16173.atmlocator.model.Location;
import com.google.gson.Gson;

import java.util.List;



public class ATMLocatorResponseParser {


    Gson gson = new Gson();
    ATMLocatorResponseDTO atmLocatorResponseDTO = new ATMLocatorResponseDTO();

    public ATMLocatorResponseDTO atmLocatorResponseParser(String jsonResp) {
        try {
            atmLocatorResponseDTO = gson.fromJson(jsonResp, ATMLocatorResponseDTO.class);
            List<Object> errors = atmLocatorResponseDTO.getErrors();
            List<Location> locations = atmLocatorResponseDTO.getLocations();

            if (errors == null && locations != null) {
                for (int index = 0; index < locations.size(); index++) {
                    Location location = locations.get(index);
                    if (location != null) {
                        String state = location.getState();
                        String locType = location.getLocType();
                        String label = location.getLabel();
                        String address = location.getAddress();
                        String city = location.getCity();
                        String zip = location.getZip();
                        String name = location.getName();
                        String lat = location.getLat();
                        String lng = location.getLng();
                        String bank = location.getBank();
                        String type = location.getType();
                        List<String> lobbyHrs = location.getLobbyHrs();
                        for (int indexL = 0; indexL < lobbyHrs.size(); indexL++) {
                            if (lobbyHrs.get(indexL).equalsIgnoreCase("")) {
                                lobbyHrs.set(indexL, "Closed");
                            }
                        }
                        List<String> driveUpHrs = location.getDriveUpHrs();
                        for (int indexD = 0; indexD < driveUpHrs.size(); indexD++) {
                            if (driveUpHrs.get(indexD).equalsIgnoreCase("")) {
                                driveUpHrs.set(indexD, "Closed");
                            }
                        }
                        Integer atms = location.getAtms();
                        List<String> services = location.getServices();
                        String phone = location.getPhone();
                        double distance = location.getDistance();
                        String access = location.getAccess();
                    }
                }
            } else {
                //todo alert box showing service call failed
            }
        } catch (Exception e) {
            Log.e("ATMLocatorResponseParse", "Parsing failed" + e.getMessage());
        }
        return atmLocatorResponseDTO;
    }
}
*/
