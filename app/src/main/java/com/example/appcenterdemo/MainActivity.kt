package com.example.appcenterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appcenterdemo.databinding.ActivityMainBinding
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCenter.start(application,
            "371e37d9-e628-495b-81ab-8852b2126145",
            Analytics::class.java,
            Crashes::class.java)
        binding.btnCalculate.setOnClickListener {
            val rate = binding.etInterestRate.text.toString()
            if (rate.toInt() <= 0) {
                Analytics.trackEvent("Wrong interest rate")
            }
        }
    }
}