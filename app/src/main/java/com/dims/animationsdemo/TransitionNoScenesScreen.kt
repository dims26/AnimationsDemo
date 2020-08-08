package com.dims.animationsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_transition_no_scenes_screen.*

class TransitionNoScenesScreen : AppCompatActivity() {

    private var visibile = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_no_scenes_screen)
    }

    fun fadeAnimation(view: View) {
        val transition = Fade()
        TransitionManager.beginDelayedTransition(sceneRoot, transition)
        txvDescription.visibility = if (visibile) View.INVISIBLE else View.VISIBLE
        visibile = !visibile
    }

    fun slideEffect(view: View) {

        val transition = Slide(Gravity.END)
        TransitionManager.beginDelayedTransition(sceneRoot, transition)

        txvDescription.visibility = if (visibile) View.INVISIBLE else View.VISIBLE
        visibile = !visibile
    }

    fun moveToKeyFrameAnim(view: View){
        val intent = Intent(this, KeyFrameAnimOnConstraintLayout::class.java)
        startActivity(intent)
    }

    fun moveToRVAnimLibrary(view: View){
        val intent = Intent(this, RVLibraryAnimScreen::class.java)
        startActivity(intent)
    }
}