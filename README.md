Cordova Kiosk Mode
==================

Cordova plugin to create Cordova application with "kiosk mode".
App with this plugin can be set as Android launcher.
If app starts as launcher, it will block hardware buttons and statusbar,
which would allow escape from application.

Escape from app will be possible only by javascript call KioskPlugin.exitKiosk()
or by uninstallation app using adb. (Keeping USB debug allowed recommended.)
If applications starts as usual (not as launcher), no restrictions will be applied.

Plugin website: https://github.com/honza889/cordova-plugin-kiosk
Example app: https://github.com/honza889/cordova-kiosk-demo

**Note for iOS:** This plugin is for Android for now. Support of iOS would be useless, becase this feature is builded in iOS as Guided Access - see Settings - General - Accessibility - Guided Access

About
-----

By adding this Cordova plugin the Cordova app becomes the the homescreen (also known as launcher) of Android device and will block any atempt of user to escape.

To add plugin into existing Cordova / Phonegap application:

    cordova plugin add https://github.com/honza889/cordova-plugin-kiosk.git

The `AndroidManifest.xml` should be updated immediately. If not, you can force it by removing and re-adding Android platform:

    cordova platform rm android
    cordova platform add android

To it work user have to set this application as launcher (see below) and start it by pressing Home button.

**WARNING** Before installation ensure you have USB debug mode enabled. Without it you can have problem to remove app from device.

Exiting from Kiosk mode using Javascript:

    KioskPlugin.exitKiosk();

For using example see: https://github.com/honza889/cordova-kiosk-demo

Tips
----

* **To remove this application use `adb`:** (Do not install it without USB debug mode enabled!) (com.example.hello replace with package of your app from your config.xml)

        $ANDROID_HOME/platform-tools/adb uninstall com.example.hello

* **To change launcher (reset setting which launcher is default):**
 * **Alcatel:** Settings - Applications - All - (This Application) / Launcher - Clear defaults, after Home press will be asked for default to set
 * **Xiaomi:** Settings - Installed apps - Defaults - Launcher

* **To disable screenlock: ("slide to unlock")**
 * **Alcatel:** Settings - Security - Set up screen lock - None
 * **Xiaomi:** Settings - Additional settings - Developer options - Skip screen lock

**"Application Error - The connection to the server was unsuccessful. (file:///android_asset/www/index.html)" occured**

* This can occure when Cordova's MainActivity is started too soon after system bootup. Because this is native HomeActivity here - if you will see this error message, try increase delay in `timer.schedule` in `HomeActivity.java`.
* Another reason can be the `index.html` is missing.
* Another reason can be too long loading of `index.html` -- you can set timeout of Cordova's WebView in `config.xml` of application: (value is in miliseconds)

        <preference name="loadUrlTimeoutValue" value="60000" />

