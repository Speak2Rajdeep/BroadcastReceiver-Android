package com.example.myreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "AeroPlane mode is turning on", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context, "AeroPlane mode is turning off", Toast.LENGTH_LONG).show();
        }
    }

    private static boolean isAirplaneModeOn(Context context){
        try {
            return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON)!= 0;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}