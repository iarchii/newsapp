package xyz.thecodeside.news.helpers

import android.app.Activity
import android.widget.Toast

fun Activity.showToastShort(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
fun Activity.showToastShort(message: Int) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Activity.showToastLong(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
fun Activity.showToastLong(message: Int) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
