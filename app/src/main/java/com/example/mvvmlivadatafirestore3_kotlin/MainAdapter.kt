package com.example.mvvmlivadatafirestore3_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_main.view.*

class MainAdapter(private var context: Context, private var mArrayList: ArrayList<MainModel>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_main, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mainModel = mArrayList[position]
        val viewHolder = holder as MainViewHolder
        viewHolder.tvN.text = mainModel.eName
        viewHolder.tvD.text = mainModel.eDescrip
        viewHolder.tvD.isSelected = true
        viewHolder.tvL.text = mainModel.eLike.toString()
    }

    override fun getItemCount(): Int {
        return mArrayList.size
    }

    class MainViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        val tvN : TextView= itemView.nameR
        val tvD : TextView= itemView.descripR
        val tvL : TextView= itemView.likeR

    }
}