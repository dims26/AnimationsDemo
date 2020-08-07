package com.dims.animationsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_transitions_screen.*

class TransitionsScreen : AppCompatActivity() {
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transition: Transition
    private lateinit var transitionSet: TransitionSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transitions_screen)

        // Step 1: Create a Scene object for both the starting and ending layout
        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this)


        // Step 2: Create a Transition object to define what type of animation you want
//        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_2)//Using XML
        val cbTransition = ChangeBounds()
            .setDuration(500)
            .setInterpolator(OvershootInterpolator())

        val fadeInTransition = Fade(Fade.IN)
            .setDuration(250)
            .setStartDelay(300)
            .addTarget(R.id.txvTitle)

        val fadeOutTransition = Fade(Fade.OUT)
            .setDuration(100)
            .addTarget(R.id.txvTitle)
        transitionSet = TransitionSet()
            .setOrdering(TransitionSet.ORDERING_TOGETHER)
            .addTransition(cbTransition)
            .addTransition(fadeInTransition)
            .addTransition(fadeOutTransition)

        scene1.enter()
        currentScene = scene1


        scene1.enter()
        currentScene = scene1
    }

    fun onClick(view: View) {
        // Step 3: Call TransitionManager.go() to run animation
        currentScene = if (currentScene == scene1) {
//            TransitionManager.go(scene2, transition)
            TransitionManager.go(scene2, transitionSet)
            scene2
        }else {
//            TransitionManager.go(scene1, transition)
            TransitionManager.go(scene1, transitionSet)
            scene1
        }
    }

    fun moveToTransitionsWithoutScenes(view: View){
        val intent = Intent(this, TransitionNoScenesScreen::class.java)
        startActivity(intent)
    }
}