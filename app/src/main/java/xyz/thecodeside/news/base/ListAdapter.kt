package xyz.thecodeside.news.base

import android.support.v7.widget.RecyclerView

abstract class ListAdapter<T : List<*>,VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    var items: T? = null
    override fun getItemCount(): Int = items?.size ?: 0
}