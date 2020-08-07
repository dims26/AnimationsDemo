package com.dims.animationsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.RotateAnimation
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_key_frame_anim_on_constraint_layout_detail.*

class KeyFrameAnimOnConstraintLayout : AppCompatActivity() {

    private var isDetailLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_frame_anim_on_constraint_layout)

        constraintLayout.setOnClickListener {
            if (isDetailLayout)
                swapFrames(R.layout.activity_key_frame_anim_on_constraint_layout)
            else
                swapFrames(R.layout.activity_key_frame_anim_on_constraint_layout_detail)
        }
    }

    private fun swapFrames(layoutId: Int){
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, layoutId)

        val transition = ChangeBounds()
            .setInterpolator(AnticipateOvershootInterpolator(1.0f))
            .setDuration(1200)


        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)

        isDetailLayout = !isDetailLayout
    }
}