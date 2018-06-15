package com.example.wade8.broadcastsreciverlearning;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static boolean sIsActivity2Exist;

    private MyReceiver mMyReceiver;
    private EditText mEditText;
    private Button mSendButton;
    private Button mSwitchToActivity2Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyReceiver = new MyReceiver();

        mEditText = findViewById(R.id.editText);
        mSendButton = findViewById(R.id.send);
        mSwitchToActivity2Button = findViewById(R.id.switch_to_activity2);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEditText.getText().toString();
                Intent intent = new Intent();
                intent.setAction("com.example.wade8.broadcastreciverlearning.CHANGE_TEXT");
                intent.putExtra("content", content);
                sendBroadcast(intent, "com.example.wade8.broadcastreciverlearning.PERMISSION");
            }
        });
        mSwitchToActivity2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(mMyReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(mMyReceiver);
    }

    public void setText(){
        mEditText.setText("87");
    }
}
