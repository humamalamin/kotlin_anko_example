package com.example.humam.submitquiz1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.humam.submitquiz1.R.id.image
import com.example.humam.submitquiz1.R.id.name
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.intentFor

class RecyclerAdapter(private  val context: Context,private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(ListData().createView(AnkoContext.Companion.create(parent.context,parent)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    inner class ViewHolder (override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{


        fun bindItem(items: Item,listener: (Item) -> Unit){
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)
            itemView.setOnClickListener {
//                context.startActivity(context.intentFor<Detail>("name" to "${tvTitle}"))
                listener(items)
            }
        }
    }

}