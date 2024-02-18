package com.example.movieapp.core.util

import timber.log.Timber

object LogFunctions {
    fun logError(tag: String,messege: String) {
        Timber.tag(tag).e("Error -> $messege")
    }
    fun logInfo(tag: String,messege: String) {
        Timber.tag(tag).i("Info -> $messege")
    }
}