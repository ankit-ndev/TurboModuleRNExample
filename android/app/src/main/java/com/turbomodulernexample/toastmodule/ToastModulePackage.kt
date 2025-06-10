package com.turbomodulernexample.toastmodule

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider
import java.util.HashMap

class ToastModulePackage : BaseReactPackage() {

    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
        return when (name) {
            ToastModule.NAME -> ToastModule(reactContext)
            else -> null
        }
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
        return ReactModuleInfoProvider {
            val moduleInfos: MutableMap<String, ReactModuleInfo> = HashMap()
            val isTurboModule = true
            moduleInfos[ToastModule.NAME] = ReactModuleInfo(
                ToastModule.NAME,
                ToastModule.NAME,
                false, // canOverrideExistingModule
                false, // needsEagerInit
                true,  // has                    Constants
                false, // is                   OriginalAttempt
                isTurboModule // isTurboModule
            )
            moduleInfos
        }
    }
}