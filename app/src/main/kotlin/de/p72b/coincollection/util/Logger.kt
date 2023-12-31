package de.p72b.coincollection.util

import android.util.Log

class Logger {

    companion object {
        private const val defaultTag = "COIN_COLLECTION_P72B"
        private var allowLogging = false

        fun setEnabled(isEnabled: Boolean) {
            allowLogging = isEnabled
        }

        fun d(tag: String = defaultTag, msg: String) {
            if (allowLogging.not()) return
            Log.d(tag, msg)
        }

        fun e(tag: String = defaultTag, msg: String, throwable: Throwable) {
            if (allowLogging.not()) return
            Log.e(tag, msg, throwable)
        }
    }
}