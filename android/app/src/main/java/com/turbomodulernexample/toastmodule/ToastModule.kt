package com.turbomodulernexample.toastmodule

import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = ToastModule.NAME)
class ToastModule(reactContext: ReactApplicationContext) : NativeToastModuleSpec(reactContext) {

    override fun getName(): String {
        return NAME
    }

    override fun show(message: String, duration: String) {
        val toastDuration = when (duration) {
            "SHORT" -> Toast.LENGTH_SHORT
            "LONG" -> Toast.LENGTH_LONG
            else -> Toast.LENGTH_SHORT // Default to SHORT
        }

        // Run on the UI thread as Toast messages must be shown on the UI thread
        reactApplicationContext.currentActivity?.runOnUiThread {
            Toast.makeText(reactApplicationContext, message, toastDuration).show()
        }
    }

    companion object {
        const val NAME = "ToastModule"
    }
}
