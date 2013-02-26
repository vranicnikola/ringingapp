
package com.mylifehacks.ringingapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class RingingService extends Service {
    
    public static final String LOG_TAG = "RingingService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        /*Thread t = new Thread(){
          public void run(){
              int counter = 0;
              while(true){
                  counter ++;
                  Log.d(LOG_TAG, counter + "");
              }
          } 
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
    
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
