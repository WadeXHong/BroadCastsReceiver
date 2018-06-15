package com.example.wade8.broadcastsreciverlearning;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView mTextView;
    private Button mFinishButton;
    private Button mSwitchToMainActivityButton;
    private MyReceiver mMyReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mMyReceiver = new MyReceiver();

        // 8.0以後要收到 implicit broadcast在code裡面用IntentFilter加才有用喔
        IntentFilter intentFilter = new IntentFilter("com.example.wade8.broadcastreciverlearning.CHANGE_TEXT");
        //選擇在 onCreate 和 onDestroy 做 register 和 unregister 是為了讓 Activity2 在切到下面 (onStop) 狀態下仍能收到廣播
        registerReceiver(mMyReceiver, intentFilter);


        mTextView = findViewById(R.id.textview);
        mFinishButton = findViewById(R.id.finish);
        mSwitchToMainActivityButton = findViewById(R.id.switch_to_mainActivity);

        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSwitchToMainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(mMyReceiver);

    }

    public void setText(String content){
        mTextView.setText(content);
    }
}
