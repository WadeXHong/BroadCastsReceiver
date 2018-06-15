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


        // 看你收到的intent是啥
        switch (intent.getAction()){

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean state = intent.getBooleanExtra("state", false);
                Log.d(TAG, "state : " + state);

                break;

            case "com.example.wade8.broadcastreciverlearning.CHANGE_TEXT":

                //換Activity2裡面顯示的字
                ((Activity2)context).setText(intent.getStringExtra("content"));
                Log.d(TAG, "CHANGE_TEXT");

                break;

            default:
                Log.d(TAG, "WTF ? 哪來奇怪的廣播 ??????????");

        }



//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
