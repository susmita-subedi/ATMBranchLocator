package com.example.ss16173.atmlocator.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.findatm.view.FindATMActivity;

/**
 * Created by susmita on 2/11/2018.
 */

public class PermissionUtil {

    private static Context context;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public PermissionUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.permission_preferences), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void setContext(Context context) {
        context.getApplicationContext();
    }

    /*method to update permissions on SharedPreference for the first time
    used switch case coz we can add more dangerous permissions are required later
    */
    public static void updatePermissionPreference(String permission) {
        switch (permission) {
            case "location":
                editor.putBoolean(context.getString(R.string.permission_location), true);
                editor.commit();
                break;
        }
    }

    //method to check if the permission is already requested on the sharedPrefenreces or not
    public static boolean checkPermissionPreference(String permission) {
        boolean isShown = false;

        switch (permission) {
            case "location":
                isShown = sharedPreferences.getBoolean(context.getString(R.string.permission_location), false);
                break;
        }
        return isShown;
    }
}
