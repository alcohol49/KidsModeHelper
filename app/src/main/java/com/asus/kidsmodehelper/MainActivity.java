package com.asus.kidsmodehelper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(true);
        } catch (Exception e) {
            Toast.makeText(this, "Enable Wifi fail", Toast.LENGTH_SHORT).show();
        }

        try {
            startActivity(new Intent(Intent.ACTION_MAIN)
                    .setComponent(new ComponentName(
                            "com.asus.kidslauncher",
                            "com.asus.kidslauncher.AsusKidsLauncherEntry")));
        } catch (Exception e) {
            Toast.makeText(this, "You are not kid!", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}
