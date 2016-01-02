Cordova Android Homescreen / Launcher
====================================

By adding this Cordova plugin the Cordova app becomes the the homescreen (also known as launcher) of Android device.

To add plugin into existing Cordova / Phonegap application:

    cordova plugin add https://github.com/honza889/cordova-plugin-homescreen

The `AndroidManifest.xml` should be updated immediately. If not, you can force it by removing and re-adding Android platform:

    cordova platform rm android
    cordova platform add android

To it work user have to set this application as launcher. (see below)

Tips
----

**To remove this application use `adb`:** (I do not recommand to install it without USB debug mode enabled!)

    $ANDROID_HOME/platform-tools/adb uninstall com.example.hello

**To change launcher (reset setting which launcher is default):**

* **Alcatel:** Settings - Applications - All - (This Application) / Launcher - Clear defaults, after Home press will be asked for default to set
* **Xiaomi:** Settings - Installed apps - Defaults - Launcher

**To disable screenlock: ("slide to unlock")**

* **Alcatel:** Settings - Security - Set up screen lock - None
* **Xiaomi:** Settings - Additional settings - Developer options - Skip screen lock

**"Application Error - The connection to the server was unsuccessful. (file:///android_asset/www/index.html)" occured**

* This can occure when Cordova's MainActivity is started too soon after system bootup. Because this is native HomeActivity here - if you will see this error message, try increase delay in `timer.schedule` in `HomeActivity.java`.
* Another reason can be the `index.html` is missing.
* Another reason can be too long loading of `index.html` -- you can set timeout of Cordova's WebView in `config.xml` of application:

    <preference name="loadUrlTimeoutValue" value="60000" />

