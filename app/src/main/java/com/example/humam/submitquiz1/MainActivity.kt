package com.example.humam.submitquiz1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            orientation = LinearLayout.VERTICAL
            //tools:context = .MainActivity //not support attribute
            recyclerView {
                id = R.id.rc_club
                padding = dip(5)

                initData()
                layoutManager   = LinearLayoutManager(this@MainActivity)
                adapter = RecyclerAdapter(this@MainActivity,items){
//                    Toast.makeText(applicationContext,name.text,Toast.LENGTH_LONG).show()
                    startActivity<Detail>("name" to it.name, "image" to it.image, "detail" to it.detail)
                }
            }.lparams(width = matchParent)
        }
    }

    private fun initData()
    {
        val name    = resources.getStringArray(R.array.club_name)
        val image   = resources.obtainTypedArray(R.array.club_image)
        val detail  = resources.getStringArray(R.array.club_detail)
        items.clear()
        for(i in name.indices){
            items.add(Item(name[i],image.getResourceId(i,0),detail[i]))
        }

        image.recycle()
    }
}
