package com.turbomodulernexample.loggingmodule

import android.util.Log
import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.turbomodulernexample.toastmodule.NativeLoggingModuleSpec

@ReactModule(name = LoggingModule.NAME)
class LoggingModule(reactContext: ReactApplicationContext) : NativeLoggingModuleSpec(reactContext) {

    override fun getName(): String {
        return NAME
    }

    override fun nativeLog(message: String?) {
        reactApplicationContext.currentActivity?.runOnUiThread {
            Toast.makeText(reactApplicationContext, "logging", Toast.LENGTH_SHORT).show()
        }
        if (message != null) {
            Log.i("Turbo Module Example", message)
        };
    }

    companion object {
        const val NAME = "LoggingModule"
    }
}