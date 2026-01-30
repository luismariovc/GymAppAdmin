package com.example.gymappadmin.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        // Immediately navigate to Login for this example


        // Use keepOnScreenCondition if we needed to wait for data load
        // splashScreen.setKeepOnScreenCondition { ... }
    }
}