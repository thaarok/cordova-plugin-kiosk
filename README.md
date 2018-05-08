Cordova Kiosk Mode
==================

A Cordova plugin to create a Cordova application with "kiosk mode".
An app with this plugin can be set as an Android launcher.
If the app starts as a launcher, it blocks hardware buttons and statusbar,
so an user cannot close the app until the app request it.

**This plugin does not change behavior of application until it is set as launcher - home screen of the device.**

Escape from the app is possible only using javascript call `KioskPlugin.exitKiosk()`
or by uninstalling the app using `adb`. (Keeping USB debug allowed necessary.)
If the application starts as usual (not as a launcher), no restrictions are applied.

* Official plugin website: https://github.com/hkalina/cordova-plugin-kiosk
* Example app: https://github.com/hkalina/cordova-kiosk-demo

This plugin is for Android platform only. For kiosk on iOS platform check its Guided Access feature.

About
-----

By adding this Cordova plugin the Cordova app becomes a homescreen (also known as a launcher) of Android device and should block any attempt of user to leave it.

To add plugin into existing Cordova / Phonegap application use:

    cordova plugin add https://github.com/hkalina/cordova-plugin-kiosk.git

To add specific version of this plugin (like `v2.0`) use:

    cordova plugin add https://github.com/hkalina/cordova-plugin-kiosk.git#v2.0

Android platform files (like `AndroidManifest.xml`) should be updated immediately. If you will modify plugin code, you will need to re-add android platform to plugin modifications take effect:

    cordova platform rm android
    cordova platform add android

To has it working, user have to **set this application as launcher** (see below) and start it by pressing Home button or by restarting the device.

**WARNING** Before installation ensure you have USB debug mode enabled. Without USB debug enabled you can get stuck in broken kiosk application.

Short API description
---------------------

**Exiting** from Kiosk mode using Javascript in the page (for hidden/authenticated button to escape the kiosk application):

    KioskPlugin.exitKiosk();

**Detecting** whether the app is successfly running in kiosk mode (kiosk activity is opened):

    KioskPlugin.isInKiosk(function(isInKiosk){ ... });

**Detecting** whether the app (kiosk activity) is set as launcher:

    KioskPlugin.isSetAsLauncher(function(isLauncher){ ... });

The device is effectively locked only when both methods returns `true`. When the app is "in kiosk", but not set as a launcher, user can escape the app by pressing a Home button (but other buttons are still locked).

**Defining allowed buttons** - buttons whose event propagation should not be prevented - so you can for example allow setting volume up/down:

    KioskPlugin.setAllowedKeys([ 24, 25 ]); // KEYCODE_VOLUME_UP, KEYCODE_VOLUME_DOWN

For list of keycode values check KeyEvent reference: https://developer.android.com/reference/android/view/KeyEvent#KEYCODE_0

For complete example application check: https://github.com/hkalina/cordova-kiosk-demo

Tips
----

* **To remove this application use `adb`:** (Do not install it without USB debug mode enabled!) (com.example.hello replace with package of your app defined in your config.xml)

        $ANDROID_HOME/platform-tools/adb uninstall com.example.hello

* **To change launcher (reset setting which launcher is default):**
 * **Alcatel:** Settings - Applications - All - (This Application) / Launcher - Clear defaults, after Home press will be asked for default to set
 * **Xiaomi:** Settings - Installed apps - Defaults - Launcher

* **To disable screenlock: ("slide to unlock")**
 * **Alcatel:** Settings - Security - Set up screen lock - None
 * **Xiaomi:** Settings - Additional settings - Developer options - Skip screen lock

**"Application Error - The connection to the server was unsuccessful. (file:///android_asset/www/index.html)" occurred**

* One reason can be too long loading of `index.html` - you can set timeout of Cordova's WebView in `config.xml` of application: (value is in milliseconds)

        <preference name="loadUrlTimeoutValue" value="60000" />

