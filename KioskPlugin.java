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
import org.json.JSONArray;
import org.json.JSONException;

public class KioskPlugin extends CordovaPlugin {
    
    public static final String EXIT_KIOSK = "exitKiosk";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (EXIT_KIOSK.equals(action)) {
                
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                
                Intent chooser = Intent.createChooser(intent, "Select destination...");                
                if (intent.resolveActivity(cordova.getActivity().getPackageManager()) != null) {
                    cordova.getActivity().startActivity(chooser);
                }
                
                callbackContext.success();
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}

