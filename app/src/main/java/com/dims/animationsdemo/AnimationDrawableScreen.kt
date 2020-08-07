package com.dims.animationsdemo

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_animation_drawable_screen.*

class AnimationDrawableScreen : AppCompatActivity() {

    lateinit var batteryAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_drawable_screen)
    }

    override fun onStart() {
        super.onStart()
        targetImage.setBackgroundResource(R.drawable.battery_animation_list)
        batteryAnimation = targetImage.background as AnimationDrawable
        batteryAnimation.start()
    }

    // Button click event handler
    fun startStopAnimation(view: View) {
        if(batteryAnimation.isRunning) batteryAnimation.stop()
        else batteryAnimation.start()
    }

    fun animatedVectorGraphicsScreen(view: View){
        val intent = Intent(this, AnimatedVectorDrawableScreen::class.java)
        startActivity(intent)
    }
}