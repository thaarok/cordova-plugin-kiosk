package jk.cordova.plugin.kiosk;

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

public class HomeActivity extends Activity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout layout = new LinearLayout(this);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        
        Button button = new Button(this);
        button.setText("Click or press any key to begin...");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeActivity.this.startKioskActivity();
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
                HomeActivity.this.startKioskActivity();
            }
        }, 20000); // 20 seconds
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startKioskActivity();
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
    
    private void startKioskActivity() {
        Intent serviceIntent = new Intent(this, KioskActivity.class);
        startActivity(serviceIntent);
    }
}

