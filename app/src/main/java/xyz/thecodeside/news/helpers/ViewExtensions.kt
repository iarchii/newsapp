package xyz.thecodeside.news.helpers

import android.util.DisplayMetrics
import android.view.View
import android.widget.EditText


fun View?.hide() {
    this?.visibility = View.GONE
}

fun View?.show() {
    this?.visibility = View.VISIBLE
}

fun View?.invisible() {
    this?.visibility = View.INVISIBLE
}

fun View?.isVisible() = this?.visibility == View.VISIBLE


fun View?.enable() {
    this?.isEnabled = true
}

fun View?.disable() {
    this?.isEnabled = false
}

fun View?.enableClickable() {
    this?.isClickable = true
}

fun View?.disableClickable() {
    this?.isClickable = false
}

fun View.getCenterOfView() : Pair<Int,Int>{
    val centerXOfView = this.measuredWidth / 2
    val centerYOfView = this.measuredHeight / 2
    val centerXOfViewOnScreen = this.left + centerXOfView
    val centerYOfViewOnScreen = this.top + centerYOfView

    return Pair(centerXOfViewOnScreen, centerYOfViewOnScreen)
}

fun View.getMeasuredWidthHeight(): Pair<Int, Int> {
    this.measure(0, 0)
    return Pair(this.measuredWidth, this.measuredHeight)
}



fun View.convertDpToPixel(dp: Int): Int {
    val resources = context.resources
    val metrics = resources.displayMetrics
    val px = dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    return px.toInt()
}

fun View.convertPixelsToDp(px: Int): Int {
    val resources = context.resources
    val metrics = resources.displayMetrics
    val dp = px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    return dp.toInt()
}

fun EditText.getStringText(): String = this.text.toString()

