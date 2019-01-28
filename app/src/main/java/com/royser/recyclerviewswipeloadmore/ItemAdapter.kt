package com.royser.recyclerviewswipeloadmore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by A Little Boy @Nextzy on 28/1/2019 AD.
 */
class ItemAdapter(private val listBaseItem: List<ProfileItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.recyclerview_item, viewGroup, false))
    }

    override fun getItemCount(): Int = listBaseItem.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = viewHolder as ItemViewHolder
        itemHolder.onBind(listBaseItem[position])
    }

}