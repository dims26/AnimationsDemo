package com.dims.animationsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.Transition
import android.view.View
import kotlinx.android.synthetic.main.activity_transitions_screen.*

class TransitionsScreen : AppCompatActivity() {
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transition: Transition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transitions_screen)

        // Step 1: Create a Scene object for both the starting and ending layout
        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this)


        // Step 2: Create a Transition object to define what type of animation you want


        scene1.enter()
        currentScene = scene1
    }

    fun onClick(view: View) {

        // Step 3: Call TransitionManager.go() to run animation

    }
}