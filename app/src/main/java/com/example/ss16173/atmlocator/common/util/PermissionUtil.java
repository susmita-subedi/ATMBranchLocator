package com.example.ss16173.atmlocator.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ss16173.atmlocator.R;

/**
 * Created by susmita on 2/11/2018.
 */

public class PermissionUtil {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public PermissionUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.permission_preferences), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /*method to update permissions on SharedPreference for the first time
    used switch case coz we can add more dangerous permissions are required later
    */
    public void updatePermissionPreference(String permission) {
        switch (permission) {
            case "location":
                editor.putBoolean(context.getString(R.string.permission_location), true);
                editor.commit();
                break;
        }
    }

    //method to check if the permission is already requested on the sharedPrefenreces or not
    public boolean checkPermissionPreference(String permission) {
        boolean isShown = false;

        switch (permission) {
            case "location":
                isShown = sharedPreferences.getBoolean(context.getString(R.string.permission_location), false);
                break;
        }
        return isShown;
    }
}
