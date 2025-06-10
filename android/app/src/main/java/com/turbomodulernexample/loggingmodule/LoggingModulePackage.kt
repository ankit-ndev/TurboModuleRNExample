package com.turbomodulernexample.loggingmodule

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider
import java.util.HashMap

class LoggingModulePackage : BaseReactPackage() { // Your package class

    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
        // This method tells React Native how to instantiate your module
        return when (name) {
            LoggingModule.NAME -> LoggingModule(reactContext)
            else -> null
        }
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
        // This provides metadata about your module, crucial for TurboModules
        return ReactModuleInfoProvider {
            val moduleInfos: MutableMap<String, ReactModuleInfo> = HashMap()
            val isTurboModule = true
            moduleInfos[LoggingModule.NAME] = ReactModuleInfo(
                LoggingModule.NAME,
                LoggingModule.NAME,
                false, // canOverrideExistingModule
                false, // needsEagerInit
                true,  // hasConstants
                false, // isOriginalAttempt
                isTurboModule // isTurboModule (important!)
            )
            moduleInfos
        }
    }
}