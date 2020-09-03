package com.schibsted.example.longfeedwithcompose

import android.util.Log

fun debug(msg: String) {
    Log.d("XXX", msg)
}

fun error(throwable: Throwable) {
    Log.e("XXX", "Failed", throwable)
}