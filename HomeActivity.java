package jk.cordova.plugin.homescreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import org.apache.cordova.*;
import android.widget.*;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import android.net.Uri;
import java.lang.Exception;

public class HomeActivity extends Activity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout layout = new LinearLayout(this);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        
        // http://www.sureshjoshi.com/mobile/android-kiosk-mode-without-root/
        layout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                   | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION // hide Back-Home-Menu
                                   | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                   | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                                   | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                                   | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                   | View.SYSTEM_UI_FLAG_LOW_PROFILE);
        
        Button button = new Button(this);
        button.setText("Click or press any key to begin...");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeActivity.this.startMainActivity();
            }
        });
        layout.addView(button, params);
        
        setContentView(layout);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run() {
                HomeActivity.this.startMainActivity();
            }
        }, 20000); // 20 seconds
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startMainActivity();
        return true; // prevent event from being propagated
    }
    
    // http://www.andreas-schrade.de/2015/02/16/android-tutorial-how-to-create-a-kiosk-mode-in-android/
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!hasFocus) {
            Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            sendBroadcast(closeDialog);
            
            // sametime required to close opened notification area
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                public void run() {
                    Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
                    sendBroadcast(closeDialog);
                }
            }, 500); // 0.5 second
        }
    }
    
    private void startMainActivity() {
        try {
            // class MainActivity in package of app (from AndroidManifest.xml)
            Class mainActivityClass = Class.forName(getPackageName() + ".MainActivity");
            Intent serviceIntent = new Intent(this, mainActivityClass);
            startActivity(serviceIntent);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

