package com.dims.animationsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator
import kotlinx.android.synthetic.main.activity_r_v_library_anim_screen.*

class RVLibraryAnimScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_v_library_anim_screen)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        val adapter = RecyclerAdapter(this, Landscape.data)
        recyclerView.adapter = SlideInRightAnimationAdapter(adapter)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        recyclerView.itemAnimator = jp.wasabeef.recyclerview.animators.OvershootInRightAnimator()
        with(recyclerView.itemAnimator!!){
            addDuration = 500 //for item add operation
            removeDuration = 500 //for item delete operation
        }
    }
}