package jk.cordova.plugin.homescreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import org.apache.cordova.*;
import android.widget.*;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import android.net.Uri;
import java.lang.Exception;

public class HomeActivity extends Activity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        LinearLayout layout = new LinearLayout(this);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        
        Button button = new Button(this);
        button.setText("Click to begin...");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent serviceIntent = new Intent(HomeActivity.this, getMainActivityClass());
                HomeActivity.this.startActivity(serviceIntent);
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
                Intent serviceIntent = new Intent(HomeActivity.this, getMainActivityClass());
                HomeActivity.this.startActivity(serviceIntent);
            }
        }, 20000); // 20 seconds
    }
    
    @Override
    public void onBackPressed() {
        // nothing here to disable Back button
    }
    
    private Class getMainActivityClass() {
        try {
            return Class.forName(getPackageName() + ".MainActivity"); // MainActivity in package of app (from AndroidManifest.xml)
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

