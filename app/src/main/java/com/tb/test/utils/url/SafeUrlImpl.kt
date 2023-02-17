package com.tb.test.utils.url

import javax.inject.Inject

class SafeUrlImpl @Inject constructor() : SafeUrl {
    override fun makeUrlSafe(url: String): String {
        val normalized = url.replace(REGEX, "/")
        return if (normalized.startsWith("http://")) {
            normalized.replace("http://", "https://")
        } else {
            normalized
        }

    }

    companion object {
        private val REGEX = "(?<=[^:\\s])(/+/)".toRegex()
    }
}