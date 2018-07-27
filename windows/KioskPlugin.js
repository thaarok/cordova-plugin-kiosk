module.exports = {

    exitKiosk: function () {
		// TODO to be done
		console.log("From cordova-plugin-kiosk windows platform: KioskPlugin.exitKiosk will be implemented soon!");
	},
    
    isInKiosk: function (callback) {
		// TODO to be done
		console.log("From cordova-plugin-kiosk windows platform: KioskPlugin.isInKiosk will be implemented soon!");
    },
    
    isSetAsLauncher: function (callback) {
		// TODO to be done
		console.log("From cordova-plugin-kiosk windows platform: KioskPlugin.isSetAsLauncher will be implemented soon!");
    },
    
    setAllowedKeys: function (keyCodes) {
		// TODO to be done
		console.log("From cordova-plugin-kiosk windows platform: KioskPlugin.setAllowedKeys will be implemented soon!");
    }
};

require('cordova/exec/proxy').add('KioskPlugin', module.exports);