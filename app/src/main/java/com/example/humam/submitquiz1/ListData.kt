package com.example.humam.submitquiz1

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ListData : AnkoComponent<ViewGroup>{

    companion object {
        val img_club = 1
        val tvTitle = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            padding = dip(15)

            imageView {
                id = R.id.image
                layoutParams = LinearLayout.LayoutParams(150, 150)
                scaleType = ImageView.ScaleType.CENTER
                padding = dip(10)
            }

            textView {
                id = R.id.name
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                text = "Test"
                textSize = 16f
                textColor = Color.BLACK
            }
        }
    }
}