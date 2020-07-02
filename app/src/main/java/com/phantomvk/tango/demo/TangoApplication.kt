package com.phantomvk.tango.demo

import android.app.Application
import com.phantomvk.tango.Tango

class TangoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Tango.init(this)
    }
}