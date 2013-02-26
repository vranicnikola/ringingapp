
package com.mylifehacks.ringingapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver {
    
    public static final String LOG_TAG = "RingingReceiver";

    private static final String VOLUME_INTENT = "android.media.VOLUME_CHANGED_ACTION";
    private static final String BOOT_INTENT = "android.intent.action.BOOT_COMPLETED";
    
    @Override
    public void onReceive(Context contexts, Intent intent) {
        Log.d(LOG_TAG, intent.getAction());
        if(intent.getAction().compareTo(VOLUME_INTENT) == 0){
            int volume = (Integer) intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");
            Log.d(LOG_TAG, volume + "");
        } else if (intent.getAction().compareTo(BOOT_INTENT) == 0){
            Intent serviceIntent = new Intent();
            serviceIntent.setAction("com.mylifehacks.ringingapp.RingingService");
            contexts.startService(serviceIntent);
        } else {
            Log.d(LOG_TAG, "nothing");
        }   
    }
}
