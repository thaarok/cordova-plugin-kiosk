Custom Android Homescreen / Launcher
====================================

By adding this Cordova plugin the Cordova app becomes the the homescreen (also known as launcher) of Android device.

To add plugin into existing Cordova / Phonegap application:

    cordova plugin add https://github.com/honza889/cordova-plugin-homescreen

The `AndroidManifest.xml` should be updated immediately. If not, you can force it by removing and re-adding Android platform:

    cordova platform rm android
    cordova platform add android

You will select which application will be launcher after clicking on Home button - when you will have more launchers, Android will ask you which of them use and allow remember it.

