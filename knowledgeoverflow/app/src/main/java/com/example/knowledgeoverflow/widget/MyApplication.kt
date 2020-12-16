package com.example.knowledgeoverflow.widget

import android.app.Application
import com.example.knowledgeoverflow.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MyApplication)
            val modules = listOf(myModule)
            modules(modules)
        }
    }
}