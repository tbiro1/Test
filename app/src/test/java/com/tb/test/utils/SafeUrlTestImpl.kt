package com.tb.test.utils

import com.tb.test.utils.url.SafeUrl
import com.tb.test.utils.url.SafeUrlImpl

class SafeUrlTestImpl : SafeUrlTest() {
    override fun getInstance(): SafeUrl {
        return SafeUrlImpl()
    }
}