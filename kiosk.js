
var exec = require('cordova/exec');

var KioskPlugin = {
    
    exitKiosk: function () {
        exec(function () {}, function (error) {
            alert("KioskPlugin.exitKiosk failed: " + error);
        }, "KioskPlugin", "exitKiosk", []);
    },
    
    isInKiosk: function (callback) {
        if(/ios|iphone|ipod|ipad/i.test(navigator.userAgent)) {
            callback(false); // ios not supported - cannot be in kiosk
            return;
        }
        exec(function (out) {
            callback(out == "true");
        }, function (error) {
            alert("KioskPlugin.isInKiosk failed: " + error);
        }, "KioskPlugin", "isInKiosk", []);
    },
    
    isSetAsLauncher: function (callback) {
        if(/ios|iphone|ipod|ipad/i.test(navigator.userAgent)) {
            callback(false); // ios not supported - cannot be in kiosk
            return;
        }
        exec(function (out) {
            callback(out == "true");
        }, function (error) {
            alert("KioskPlugin.isSetAsLauncher failed: " + error);
        }, "KioskPlugin", "isSetAsLauncher", []);
    },
    
    setAllowedKeys: function (keyCodes) {
        exec(function () {}, function (error) {
            alert("KioskPlugin.setAllowedKeys failed: " + error);
        }, "KioskPlugin", "setAllowedKeys", keyCodes);
    }
    
}

module.exports = KioskPlugin;

