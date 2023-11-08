package com.example.banco_calamo.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.banco_calamo.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lottieAnimationView: LottieAnimationView = binding.animationView

        lottieAnimationView.playAnimation()

     /*   binding.animationView.postDelayed({
            startActivity(intent)
            finish()
            splashscreenduration

        }) */
    }

}

