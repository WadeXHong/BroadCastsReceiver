package com.example.wade8.broadcastsreciverlearning;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private final String TAG = MyReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d(TAG, "onReceive executed");


        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {

            boolean state = intent.getBooleanExtra("state", false);
            Log.d(TAG, "state : " + state);

        }else if (intent.getAction().equals("com.example.wade8.broadcastreciverlearning.CHANGE_TEXT")){

            Log.d(TAG, "CHANGE_TEXT");
            ((Activity2)context).setText(intent.getStringExtra("content"));

        }else {
            Log.d(TAG, "WTF?");
        }


//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
