package com.dims.animationsdemo

import android.animation.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener{

    private var rotateAnimator: ObjectAnimator? = null
    private var translateAnimator: ObjectAnimator? = null
    private var scaleAnimator: ObjectAnimator? = null
    private var fadeAnimator: ObjectAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rotateAnimation(view: View) {

        rotateAnimator = ObjectAnimator.ofFloat(targetImage, "rotation", 0.0f, -180.0f)
        rotateAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun scaleAnimation(view: View) {

        scaleAnimator = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 3.0f)
        scaleAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun translateAnimation(view: View) {

        translateAnimator = ObjectAnimator.ofFloat(targetImage, "translationX", 0f, 200f)
        translateAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }

        // translateAnimator.cancel()
    }

    fun fadeAnimation(view: View) {

        fadeAnimator = ObjectAnimator.ofFloat(targetImage, "alpha", 1f, 0f)
        fadeAnimator?.apply {
            duration = 1500
            repeatMode = ValueAnimator.REVERSE
            repeatCount = 1
            addListener(this@MainActivity)
            start()
        }
    }

    fun viewPropertyAnimator(view: View) {
        val vpa = targetImage.animate()
        vpa.apply {
            duration = 1000
            rotationX(360f)
            scaleX(1.5f)
            scaleY(1.5f)
            interpolator = OvershootInterpolator()
            start()
        }
    }

    fun propertyValuesHolder(view: View) {
        val rotXValHolder = PropertyValuesHolder.ofFloat("rotationX", 360f)
        val scalXValHolder = PropertyValuesHolder.ofFloat("scaleX", 1.5f)
        val scalYValHolder = PropertyValuesHolder.ofFloat("scaleY", 1.5f)

        val animator = ObjectAnimator.ofPropertyValuesHolder(targetImage, rotXValHolder, scalXValHolder, scalYValHolder)
            .setDuration(1000)
        with(animator){
            interpolator = OvershootInterpolator()
            repeatMode = ValueAnimator.REVERSE
            repeatCount = 1
            start()
        }
    }

    // Implementation of AnimatorListener interface
    override fun onAnimationStart(animation: Animator?) {
        lateinit var type: String

        when(animation){
            fadeAnimator -> type = "fadeAnimator"
            translateAnimator -> type = "translateAnimator"
            scaleAnimator -> type = "scaleAnimator"
            rotateAnimator -> type = "rotateAnimator"
        }

        Toast.makeText(this, "$type Animation Started", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationRepeat(animation: Animator?) {
        lateinit var type: String

        when(animation){
            fadeAnimator -> type = "fadeAnimator"
            translateAnimator -> type = "translateAnimator"
            scaleAnimator -> type = "scaleAnimator"
            rotateAnimator -> type = "rotateAnimator"
        }

        Toast.makeText(this, "$type Animation Repeated", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(animation: Animator?) {
        lateinit var type: String

        when(animation){
            fadeAnimator -> type = "fadeAnimator"
            translateAnimator -> type = "translateAnimator"
            scaleAnimator -> type = "scaleAnimator"
            rotateAnimator -> type = "rotateAnimator"
        }

        Toast.makeText(this, "$type Animation Ended", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(animation: Animator?) {
        lateinit var type: String

        when(animation){
            fadeAnimator -> type = "fadeAnimator"
            translateAnimator -> type = "translateAnimator"
            scaleAnimator -> type = "scaleAnimator"
            rotateAnimator -> type = "rotateAnimator"
        }

        Toast.makeText(this, "$type Animation Cancelled", Toast.LENGTH_SHORT).show()
    }

    fun setFromXML(view: View) {
        val setAnimator = AnimatorInflater.loadAnimator(this, R.animator.set)
        setAnimator.apply {
            setTarget(targetImage)
            start()
        }
    }

    fun setFromCode(view: View) {
        // Root Animator Set
        val rootSet = AnimatorSet()

        // Flip Animation
        val flip = ObjectAnimator.ofFloat(targetImage, "rotationX", 0.0f, 360.0f)
            .setDuration(500)

        // Child Animator Set
        val childSet = AnimatorSet()

        // Scale Animations
        val scaleX = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 1.5f)
            .setDuration(500)
        scaleX.interpolator = BounceInterpolator()

        val scaleY = ObjectAnimator.ofFloat(targetImage, "scaleY", 1.0f, 1.5f)
            .setDuration(500)
        scaleY.interpolator = BounceInterpolator()

//        rootSet.playSequentially(flip, childSet)
//        childSet.playTogether(scaleX, scaleY)

        rootSet.play(flip).before(childSet)
        childSet.play(scaleX).with(scaleY)

        rootSet.start()
    }

    fun animationDrawableScreen(view: View) {
        val intent = Intent(this, AnimationDrawableScreen::class.java)
        startActivity(intent)
    }
}