Custom Android Homescreen / Launcher
====================================

By adding this Cordova plugin the Cordova app becomes the the homescreen (also known as launcher) of Android device.

To add plugin into existing Cordova / Phonegap application:

    cordova plugin add https://github.com/honza889/cordova-plugin-homescreen

The `AndroidManifest.xml` should be updated immediately. If not, you can force it by removing and re-adding Android platform:

    cordova platform rm android
    cordova platform add android

You will select which application will be launcher after clicking on Home button - when you will have more launchers, Android will ask you which of them use and allow remember it.

If error "Application Error - The connection to the server was unsuccessful. (file:///android_asset/www/index.html)" occure, try add following into config.xml of application:

    <preference name="loadUrlTimeoutValue" value="60000" />

(Timeout is in miliseconds, value 60000 = 60 second)

Tips
----

**To remove this application use `adb`:** (I do not recommand to install it without USB debug mode enabled!)

    $ANDROID_HOME/platform-tools/adb uninstall com.example.hello

**To change launcher (reset setting which launcher is default):**

* **Alcatel:** Settings - Applications - All - (This Application) / Launcher - Clear defaults, after Home press will be asked for default to set
* **Xiaomi:** Settings - Installed apps - Defaults - Launcher

