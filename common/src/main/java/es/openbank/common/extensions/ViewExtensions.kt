package es.openbank.common.extensions

import android.view.LayoutInflater
import android.view.View

fun View.getLayoutInflater(): LayoutInflater = LayoutInflater.from(this.context)

fun View?.setVisible(condition: Boolean) {
    this?.visibility = if (condition) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun View?.setInvisible(condition: Boolean) {
    this?.visibility = if (condition) {
        View.INVISIBLE
    } else {
        View.VISIBLE
    }
}