package com.asus.kidsmodehelper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            startActivity(new Intent(Intent.ACTION_MAIN)
                    .setComponent(new ComponentName(
                            "com.asus.kidslauncher",
                            "com.asus.kidslauncher.AsusKidsLauncherEntry")));
        } catch (Exception e) {
            Toast.makeText(this, "You are not kid!", Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        getPackageManager().clearPackagePreferredActivities(getPackageName());

        startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME));
    }
}
