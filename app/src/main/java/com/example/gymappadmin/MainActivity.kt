package com.example.gymappadmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.gymappadmin.view.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        
        // Immediately navigate to Login for this example
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
        
        // Use keepOnScreenCondition if we needed to wait for data load
        // splashScreen.setKeepOnScreenCondition { ... }
    }
}     