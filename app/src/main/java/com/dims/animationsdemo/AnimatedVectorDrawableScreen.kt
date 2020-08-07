package com.dims.animationsdemo

import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animated_vector_drawable_screen.*


class AnimatedVectorDrawableScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animated_vector_drawable_screen)

        var isTick = true

        avdImage.setOnClickListener {
            if (isTick) checkToClose()
            else closeToCheck()

            isTick = !isTick
        }
    }

    private fun checkToClose(){
        avdImage.setImageResource(R.drawable.avd_check_to_close)
        val avdCheckToClose = avdImage.drawable as Animatable
        avdCheckToClose.start()
    }

    private fun closeToCheck(){
        avdImage.setImageResource(R.drawable.avd_close_to_check)
        val avdCloseToCheck = avdImage.drawable as Animatable
        avdCloseToCheck.start()
    }

    fun moveToTransitions(view: View){
        val intent = Intent(this, TransitionsScreen::class.java)
        startActivity(intent)
    }
}