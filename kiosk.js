
var exec = require('cordova/exec');

var KioskPlugin = {
    
    exitKiosk: function () {
        exec(null, null, "KioskPlugin", "exitKiosk", []);
    },
    
    isInKiosk: function (callback) {
        if(/ios|iphone|ipod|ipad/i.test(navigator.userAgent)) {
            callback(false); // ios not supported - cannot be in kiosk
            return;
        }
        exec(function(out){
            callback(out == "true");
        }, function(error){
            alert("KioskPlugin.isInKiosk failed: " + error);
        }, "KioskPlugin", "isInKiosk", []);
    },
    
    isSetAsLauncher: function (callback) {
        if(/ios|iphone|ipod|ipad/i.test(navigator.userAgent)) {
            callback(false); // ios not supported - cannot be in kiosk
            return;
        }
        exec(function(out){
            callback(out == "true");
        }, function(error){
            alert("KioskPlugin.isSetAsLauncher failed: " + error);
        }, "KioskPlugin", "isSetAsLauncher", []);
    }
    
}

module.exports = KioskPlugin;

