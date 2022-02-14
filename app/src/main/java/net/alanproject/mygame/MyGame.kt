package net.alanproject.mygame

import android.app.Application
import timber.log.Timber


class MyGame:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}