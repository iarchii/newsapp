package co.quizhouse.helpers

import android.support.v7.widget.RecyclerView

/**
 * This method compares old recycler data with new recycler data and notifies the adapter
 * the right way, i.e. calling notifyItemRemoved and notifyItemInserted (animation-compatible).
 */
fun <T> RecyclerView.Adapter<out RecyclerView.ViewHolder>.replaceData(oldItems: MutableList<T>, newItems: List<T>, recyclerPositionForItemFunc: (T) -> Int): Unit{
    removeData(oldItems, newItems, recyclerPositionForItemFunc)
    addData(oldItems, newItems, recyclerPositionForItemFunc)
}

/**
 *
 * Adds items which are in [newItems] but are not in [oldItems] and calls notifyItemInserted() for them for smooth animation
 *
 * @param oldItems - the list of items which are currently shown in the adapter
 * @param newItems - the list of items which should be shown after the adapter is refreshed
 * @param recyclerPositionForItemFunc - function which returns the real position of the item in the adapter
 *                                      (may be different than the position in the list, because there may be several item types in the adapter)
 */
fun <T> RecyclerView.Adapter<out RecyclerView.ViewHolder>.addData(oldItems: MutableList<T>, newItems: List<T>, recyclerPositionForItemFunc: (T) -> Int): Unit{
    newItems.forEachIndexed { i, newItem ->
        if(!oldItems.contains(newItem)) {
            oldItems.add(Math.min(i, oldItems.size), newItem) //indexed, so that the order is taken into account
            notifyItemInserted(recyclerPositionForItemFunc.invoke(newItem))
        }
    }
}

/**
 *
 * Removes items which are in [oldItems] but are not in [newItems] anymore and calls notifyItemRemoved() for them for smooth animation
 *
 * @param oldItems - the list of items which are currently shown in the adapter
 * @param newItems - the list of items which should be shown after the adapter is refreshed
 * @param recyclerPositionForItemFunc - function which returns the real position of the item in the adapter
 *                                      (may be different than the position in the list, because there may be several item types in the adapter)
 */
fun <T> RecyclerView.Adapter<out RecyclerView.ViewHolder>.removeData(oldItems: MutableList<T>, newItems: List<T>, recyclerPositionForItemFunc: (T) -> Int): Unit{
    val iterator = oldItems.iterator()
    while(iterator.hasNext()){
        val oldItem = iterator.next()
        if(!newItems.contains(oldItem)){
            val position = recyclerPositionForItemFunc.invoke(oldItem)
            iterator.remove()
            notifyItemRemoved(position)
        }
    }
}

/**
 * Removes [item] from [oldItems] and calls notifyItemRemoved() for them for smooth animation
 */
fun <T> RecyclerView.Adapter<out RecyclerView.ViewHolder>.removeData(oldItems: MutableList<T>, item: T, recyclerPositionForItemFunc: (T) -> Int): Unit {
    val itemPosition = recyclerPositionForItemFunc.invoke(item)
    oldItems.remove(item)
    notifyItemRemoved(itemPosition)
}
