package com.example.humam.submitquiz1

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.humam.submitquiz1.R.id.*
import org.jetbrains.anko.*

class Detail : AppCompatActivity() {

    private var name: String = ""
    lateinit var nameTextView: TextView
    private var image : Int = 0
    lateinit var images: ImageView
    private var detail: String= ""
    lateinit var details: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            orientation = LinearLayout.VERTICAL
            padding = dip(10)
            nameTextView    = textView()
            images  = imageView()
            details = textView()
            imageView {
                id = R.id.image_detail
                scaleType = ImageView.ScaleType.FIT_CENTER
            }.lparams(width = dip(200), height = dip(150))
            textView {
                textSize = dip(20).toFloat()
                setTypeface(typeface, Typeface.BOLD)
                id = R.id.tv_detail
            }
            textView {
                id = R.id.detail
            }
        }

        val intent   = intent
        name    = intent.getStringExtra("name");
        image   = intent.getIntExtra("image",0)
        detail  = intent.getStringExtra("detail")

        nameTextView.text   = name
        Glide.with(images).load(image).into(images)
        details.text    = detail

    }

}