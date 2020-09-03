package com.schibsted.example.longfeedwithcompose

import android.util.Log

fun debug(msg: String) {
    Log.d("DUPA", msg)
}

fun error(throwable: Throwable) {
    Log.e("DUPA", "Jeblo sie", throwable)
}