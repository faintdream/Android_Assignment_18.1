package com.example.homepc.broadcastreceiverbatterymanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //note": the Batterymanager intent is a sticky intent means it stays ON as long as phone is on


    TextView batteryStatus;

    //declaring a broadcast receiver to capture battery level event
    private BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            batteryStatus.setText("Battery Level Remaining: "+ String.valueOf(level) + "%");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batteryStatus=findViewById(R.id.batterystatusTV);

        //registering for the battery change action intent
        this.registerReceiver(this.broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
