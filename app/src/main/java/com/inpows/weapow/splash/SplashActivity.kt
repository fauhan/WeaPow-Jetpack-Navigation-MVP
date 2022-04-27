package com.inpows.weapow.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.airbnb.lottie.LottieAnimationView
import com.inpows.weapow.MainActivity
import com.inpows.weapow.R
import com.inpows.weapow.base.BaseActivity
import com.inpows.weapow.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!
    private var bottom: Animation? = null
    private lateinit var lottieAnimationViewWeather: LottieAnimationView
    override fun init() {}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lottieAnimationViewWeather = binding.animationViewSplash

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom)
        binding.tvSplashText.animation = bottom
        lottieAnimationViewWeather.setAnimation("ic_broken_clouds_04n.json")

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}