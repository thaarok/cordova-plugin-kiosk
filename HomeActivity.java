package com.example.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import org.apache.cordova.*;
import android.widget.*;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;

public class HomeActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        LinearLayout layout = new LinearLayout(this);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        
        final Activity activity = this;        
        Button button = new Button(this);
        button.setText("Show cordova activity");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
                Intent serviceIntent = new Intent(activity, MainActivity.class);
                //serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(serviceIntent);
                
            }
        });
        
        layout.addView(button, params);
        setContentView(layout);
    }
    
    @Override
    public void onBackPressed() {
        // nothing here to disable Back button
    }
}

