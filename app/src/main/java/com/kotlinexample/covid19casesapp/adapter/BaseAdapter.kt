package com.kotlinexample.covid19casesapp.adapter


import androidx.recyclerview.widget.RecyclerView
import com.kotlinexample.covid19casesapp.databinding.RecyclerViewItemBinding


abstract class BaseAdapter<VH : BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() {
    var items: ArrayList<Any> = ArrayList()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    fun getItem(position: Int): Any {
        return items[position]
    }

    fun add(newItem: Any) {
        items.add(newItem)
    }

    fun add(newItems: List<Any>) {
        items.addAll(newItems)
    }

    abstract class BaseViewHolder(var viewBinding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        abstract fun bind(item: Any)
    }
}