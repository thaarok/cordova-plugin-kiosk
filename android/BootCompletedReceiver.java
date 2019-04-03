package jk.cordova.plugin.kiosk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.Override;
import java.lang.System;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.AlarmManager;


/**
 * Used to ensure app brought front by relaunching and so receives NFC events
 */
public class BootCompletedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run() {
                System.out.println("Restarting kiosk app...");
                String myPackage = context.getPackageName();
                Intent restartIntent = context.getPackageManager().getLaunchIntentForPackage(myPackage);
                PendingIntent intent = PendingIntent.getActivity(context, 0, restartIntent, Intent.FLAG_ACTIVITY_CLEAR_TOP);
                AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                manager.set(AlarmManager.RTC, System.currentTimeMillis() + 1, intent);
                System.exit(0);
            }
        }, 10000);
    }
}

